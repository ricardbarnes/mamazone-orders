group = "cat.vonblum"
version = "0.0.1-SNAPSHOT"

plugins {
    id("org.springframework.boot") version ("3.1.1")
    id("io.spring.dependency-management") version ("1.1.0")
    id("com.google.protobuf") version ("0.9.4")
    kotlin("jvm") version ("1.9.0")
    kotlin("plugin.spring") version ("1.9.0")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain:application"))
    implementation(project(":shared:domain"))
    implementation("org.springframework.boot:spring-boot-starter:3.1.2")
    implementation("io.grpc:grpc-netty:1.46.0")
    implementation("io.grpc:grpc-protobuf:1.53.0")
    implementation("io.grpc:grpc-stub:1.46.0")
    implementation("io.grpc:grpc-kotlin-stub:1.2.0")
    implementation("com.google.protobuf:protobuf-kotlin:3.19.6")
    implementation("com.google.protobuf:protobuf-java:3.19.6")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:21.0-rc-1"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.53.0"
        }
        create("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.3.0:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
                create("grpckt")
            }
            it.builtins {
                create("kotlin")
            }
        }
    }
}
