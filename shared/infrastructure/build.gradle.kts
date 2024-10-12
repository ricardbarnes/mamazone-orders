group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin ("jvm") version ("2.0.21")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared:domain"))
    implementation(project(":domain:core"))
    implementation("org.springframework.boot:spring-boot-starter:3.3.4")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}