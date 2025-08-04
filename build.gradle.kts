plugins {
    `java-library`
    id("io.deepmedia.tools.deployer") version "0.18.0"
}

group = "fr.kenlek.j4p"
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

tasks.withType<JavaExec>().configureEach {
    jvmArgs(
        "--enable-native-access=ALL-UNNAMED"
    )
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
