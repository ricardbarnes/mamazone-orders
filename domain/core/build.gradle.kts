plugins {
    kotlin("jvm") version ("1.9.0")
}

group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared:domain"))
}