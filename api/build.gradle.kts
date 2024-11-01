group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin("jvm") version ("2.0.21")
    kotlin("plugin.spring") version ("2.0.21")
    application
    id("org.springframework.boot") version ("3.1.1")
    id("io.spring.dependency-management") version ("1.1.0")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain:application"))
    implementation(project(":shared:domain"))
    implementation(project(":shared:infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
}
