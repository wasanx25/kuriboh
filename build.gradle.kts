val assertjVersion: String by project
val detektVersion: String by project
val junitPlatformVersion: String by project
val spekVersion: String by project

buildscript {
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0")
    }
}

apply {
    plugin("org.junit.platform.gradle.plugin")
}

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.gitlab.arturbosch.detekt:detekt-api:$detektVersion")

    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("io.gitlab.arturbosch.detekt:detekt-test:$detektVersion")
    testImplementation("org.junit.platform:junit-platform-launcher:$junitPlatformVersion")
    testImplementation("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
}
