plugins {
    kotlin("jvm") version "1.4.21" apply false
    id("io.gitlab.arturbosch.detekt") version "1.15.0"
}

val parentProjectDir = projectDir

subprojects {
    group = "com.karvozavr"

    repositories {
        mavenLocal()
        jcenter()
        mavenCentral()
    }

    apply {
        plugin("java")
        plugin("io.gitlab.arturbosch.detekt")
        plugin("jacoco")
    }

    detekt {
        config = files("${parentProjectDir}/detekt/detekt-config.yml")
        buildUponDefaultConfig = true
    }

    val check = tasks.named<DefaultTask>("check")
    val jacocoTestReport = tasks.named<JacocoReport>("jacocoTestReport")
    val jacocoTestCoverageVerification = tasks.named<JacocoCoverageVerification>("jacocoTestCoverageVerification")

    check {
        finalizedBy(jacocoTestReport)
    }

    jacocoTestReport {
        dependsOn(check)
        finalizedBy(jacocoTestCoverageVerification)
    }

    jacocoTestCoverageVerification {
        dependsOn(jacocoTestReport)
    }
}