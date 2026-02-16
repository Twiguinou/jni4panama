import fr.kenlek.jpgen.api.Platform

plugins {
    `java-library`
    alias(libs.plugins.mavenPublish)
}

group = "fr.kenlek"
version = "1.1.0"
description = "Bindings for the JNI Invocation API via Java 22's FFM API"

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25

    withSourcesJar()
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(libs.jpgen.api)
}

val zigOut: Provider<Directory> = layout.buildDirectory.dir("zig-out")
val jniIncludeDirectory: Provider<Directory> = layout.buildDirectory.dir("jni-include")

tasks.register("downloadJNIHeaders") {
    group = project.name

    val headers = listOf(
        Triple("https://raw.githubusercontent.com/openjdk/jdk/refs/heads/master/src/java.base/share/native/include/jni.h", ".", "jni.h"),
        Triple("https://raw.githubusercontent.com/openjdk/jdk/refs/heads/master/src/java.desktop/share/native/include/jawt.h", ".", "jawt.h"),
        Triple("https://raw.githubusercontent.com/openjdk/jdk/refs/heads/master/src/java.base/unix/native/include/jni_md.h", "unix", "jni_md.h"),
        Triple("https://raw.githubusercontent.com/openjdk/jdk/refs/heads/master/src/java.base/windows/native/include/jni_md.h", "windows", "jni_md.h")
    )

    inputs.property("jniHeadersURIs", headers.map { it.first })
    outputs.dir(jniIncludeDirectory)

    doLast {
        for ((uri, relativeLocation, name) in headers) {
            logger.lifecycle("Downloading $relativeLocation/$name from URI: $uri")
            uri(uri).toURL().openStream().use { input ->
                val outputFile = jniIncludeDirectory.get().asFile.resolve("$relativeLocation/$name")
                outputFile.parentFile.mkdirs()
                outputFile.outputStream().use { output -> input.copyTo(output) }
            }
        }
    }
}

tasks.register<Exec>("compileNatives") {
    group = project.name
    dependsOn("downloadJNIHeaders")

    inputs.file("build.zig")
    inputs.dir("src/main/c")
    outputs.dir(zigOut)

    executable = providers.gradleProperty("${project.name}.zig").getOrElse("zig")
    args(
        "build", "--prefix", zigOut.get(), "-Doptimize=ReleaseSmall",
        "-DjniInclude=${jniIncludeDirectory.get()}"
    )
}

tasks.jar {
    dependsOn("compileNatives")

    from(zigOut.map { fileTree(it).files }) {
        include("*.so", "*.dll", "*.dylib")
        into("fr/kenlek/${project.name}/natives")
    }
}

tasks.compileJava.configure {
    options.javaModuleVersion = version.toString()
    options.compilerArgs.addAll(listOf("-Xlint:all,-restricted", "-Werror"))
}

tasks.withType<JavaExec>().configureEach {
    dependsOn("compileNatives")

    jvmArgs("--enable-native-access=ALL-UNNAMED")
    systemProperty("${project.name}.library.path", zigOut.get().dir(
        if (Platform.OS.WINDOWS.isCurrent) "bin" else "lib"
    ).file(System.mapLibraryName("${project.name}-${Platform.CURRENT.code()}")))
}

mavenPublishing {
    coordinates(group.toString(), name, version.toString())
    pom {
        name = project.name
        description = project.description
        url = "https://github.com/Twiguinou/jni4panama"
        developers {
            developer {
                name = "kenlek"
                email = "akushiru@kenlek.fr"
                url = "https://github.com/Twiguinou"
            }
        }

        licenses {
            license {
                name = "Apache-2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        scm {
            connection = "scm:git:git://github.com/Twiguinou/jni4panama.git"
            developerConnection = "scm:git:ssh://github.com:Twiguinou/jni4panama.git"
            url = "https://github.com/Twiguinou/jni4panama/tree/master"
        }
    }

    publishToMavenCentral()
    signAllPublications()
}
