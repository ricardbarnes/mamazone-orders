group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

plugins {
    id("org.springframework.boot") version ("3.1.1")
    id("io.spring.dependency-management") version ("1.1.0")
    kotlin("jvm") version ("1.9.0")
    kotlin("plugin.spring") version ("1.9.0")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain:core"))
    implementation(project(":shared:domain"))
    implementation("org.springframework.boot:spring-boot-starter:3.1.2")
}