plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.publish)
    alias(libs.plugins.kotlinx.serialization)
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply(from = "$rootDir/config/ktlint.gradle.kts")
}
