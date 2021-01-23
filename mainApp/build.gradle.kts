buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(kotlin("stdlib-jdk8"))
        classpath(kotlin("reflect"))
    }
}

repositories {
    mavenCentral()
    jcenter()
}

plugins {
    java
    kotlin("jvm")
    id("org.springframework.boot") version "2.4.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.4.21"
    id("io.gitlab.arturbosch.detekt") version "1.15.0"
}

group = "com.karvozavr"
version = "0.0.1-SNAPSHOT"

dependencies {
    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

detekt {
    config = files("${project.parent?.projectDir}/detekt/config.yml")
    buildUponDefaultConfig = true
}
