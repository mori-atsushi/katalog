plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    `maven-publish`
}

android {
    compileSdk = Constants.compileSdk
    buildToolsVersion = Constants.buildToolsVersion

    defaultConfig {
        minSdk = Constants.minSdk
        targetSdk = Constants.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-Xexplicit-api=strict"
        )
    }
    composeOptions {
        kotlinCompilerVersion = Versions.composeKotlinCompiler
        kotlinCompilerExtensionVersion = Versions.Androidx.compose
    }
    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
        getByName("test").java.srcDir("src/test/kotlin")
        getByName("androidTest").java.srcDir("src/androidTest/kotlin")
    }
}

dependencies {
    implementation(project(":katalog"))

    implementation(kotlin("stdlib"))

    implementation(Deps.Androidx.Core.ktx)
    implementation(Deps.Androidx.Activity.ktx)
    implementation(Deps.Androidx.Fragment.ktx)

    implementation(Deps.Androidx.Lifecycle.runtime)
    implementation(Deps.Androidx.Lifecycle.compose)

    implementation(Deps.Androidx.annotation)

    testImplementation(Deps.Androidx.Test.core)
    testImplementation(Deps.Androidx.Test.runner)
    testImplementation(Deps.Androidx.Test.rules)
    testImplementation(Deps.Androidx.Test.junit)
    testImplementation(Deps.Androidx.Test.truth)
}

ext {
    set("releaseArtifact", "katalog-android-view")
}

apply(from = "$rootDir/config/publish.gradle")
