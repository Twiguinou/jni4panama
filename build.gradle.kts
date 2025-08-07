import fr.kenlek.jpgen.api.Platform

plugins {
    `java-library`
    id("io.deepmedia.tools.deployer") version "0.18.0"
}

allprojects {
    group = "fr.kenlek"
}

version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_24
    targetCompatibility = JavaVersion.VERSION_24

    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("fr.kenlek.jpgen:jpgen-api:0.1.2")
}

val zig = providers.gradleProperty("j4p.zig").getOrElse("zig")
val zigOut = layout.buildDirectory.dir("zig-out")
val jniIncludeDirectory = layout.buildDirectory.dir("jni-include")

tasks.register("downloadJNIHeaders") {
    group = "j4p"

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
            uri(uri).toURL().openStream().use { input ->
                val outputFile = jniIncludeDirectory.get().asFile.resolve("$relativeLocation/$name")
                outputFile.parentFile.mkdirs()
                outputFile.outputStream().use { output -> input.copyTo(output) }
            }

            logger.lifecycle("Downloaded $relativeLocation/$name from URI: $uri")
        }
    }
}

tasks.register<Exec>("compileNatives") {
    group = "j4p"
    dependsOn("downloadJNIHeaders")

    executable = zig
    args(
        "build", "--prefix", zigOut.get(), "-Doptimize=ReleaseSmall",
        "-DjniInclude=${jniIncludeDirectory.get()}"
    )
}

tasks.jar {
    dependsOn("compileNatives")

    from(fileTree(zigOut).files) {
        include("*.so", "*.dll", "*.dylib")
        into("natives")
    }
}

tasks.compileJava.configure {
    options.javaModuleVersion = project.version.toString()
    options.compilerArgs.addAll(listOf("-Xlint:all,-restricted", "-Werror"))
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-native-access=ALL-UNNAMED")
    systemProperty("j4p.library.path", zigOut.get().dir(
        if (Platform.OS.WINDOWS.isCurrent) "bin" else "lib"
    ).file(System.mapLibraryName("j4p-${Platform.CURRENT.code()}")))
}

deployer {
    projectInfo {
        name = project.name
        groupId = project.group.toString()
        artifactId = project.name
        url = "http://github.com/Twiguinou/jni4panama"

        description = project.description
        license(apache2)
        developer("kenlek", "akushiru@kenlek.fr")
        scm.fromGithub("Twiguinou", "jni4panama")
    }

    release.version = project.version.toString()
    content.component {
        fromJava()
    }

    localSpec {
        signing {
            key = absent()
            password = absent()
        }
    }

    centralPortalSpec {
        auth {
            user = secret("CENTRAL_PORTAL_USER")
            password = secret("CENTRAL_PORTAL_PASSWORD")
        }

        signing {
            key = secret("SIGNING_KEY")
            password = secret("SIGNING_PASSWORD")
        }

        allowMavenCentralSync = false
    }
}
