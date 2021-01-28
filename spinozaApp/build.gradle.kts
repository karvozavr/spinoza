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
    kotlin("jvm")
    id("org.springframework.boot") version "2.4.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.4.21"
}

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

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            element = "CLASS"
            excludes = listOf("com.karvozavr.spinoza.SpinozaApplication*")
            limit {
                minimum = BigDecimal(0.8)
            }
        }
    }
}
