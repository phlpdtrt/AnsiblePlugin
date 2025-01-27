plugins {
    java
    jacoco
    id ("org.sonarqube") version "4.3.1.3277"
    id("org.jetbrains.intellij") version "0.5.0"
}

group = "ir.msdehghan"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

intellij {
    version = "2020.1.4"
    setPlugins("yaml")
    // Instrument if we are not in CI. It will make coverage wrong in tests
    instrumentCode = System.getenv("CI") == null
    updateSinceUntilBuild = false
}

sonar {
    properties {
        property("sonar.projectKey", "phlpdtrt_ansibleplugin")
        property("sonar.organization", "phlpdtrt")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
