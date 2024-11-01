group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin ("jvm") version ("2.0.21")
    kotlin("plugin.spring") version ("2.0.21")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(project(":domain:core"))
    implementation(project(":domain:application"))
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
}
