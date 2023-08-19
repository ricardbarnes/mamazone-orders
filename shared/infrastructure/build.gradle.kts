group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared:domain"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}