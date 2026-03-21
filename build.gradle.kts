plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    kotlin("kapt") version "2.3.10"
    id("org.jetbrains.kotlin.plugin.jpa") version "2.3.20-RC3"
    id("org.springframework.boot") version "4.0.3"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.graalvm.buildtools.native") version "0.11.4"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"
description = "springboot-course"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springModulithVersion"] = "2.0.3"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-restclient")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("tools.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-restclient-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // LangChain4j
    implementation("dev.langchain4j:langchain4j-spring-boot-starter:1.0.0-beta1")
    implementation("dev.langchain4j:langchain4j-open-ai-spring-boot-starter:1.0.0-beta1")


    // Map Struct
    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    kapt("org.mapstruct:mapstruct-processor:1.6.3")

    // Validations
    implementation("org.springframework.boot:spring-boot-starter-validation")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
