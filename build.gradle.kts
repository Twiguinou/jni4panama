plugins {
    `java-library`
}

group = "fr.kenlek.j4p"
version = "1.0.0"

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
