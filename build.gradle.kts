// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    }
}

plugins {
    id("com.vanniktech.maven.publish") version "0.18.0"
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply(from = "$rootDir/config/ktlint.gradle.kts")

    repositories {
        google()
        mavenCentral()
    }
}
