plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.vanniktech.maven.publish")
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
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-Xexplicit-api=strict",
            "-Xopt-in=kotlin.RequiresOptIn"
        )
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Androidx.composeCompiler
    }
    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
        getByName("test").java.srcDir("src/test/kotlin")
        getByName("androidTest").java.srcDir("src/androidTest/kotlin")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":katalog"))

    implementation(Deps.Androidx.Compose.ui)
    implementation(Deps.Androidx.Compose.uiTooling)
    implementation(Deps.Androidx.Compose.foundation)
    implementation(Deps.Androidx.Compose.material)

    implementation(Deps.Androidx.Core.ktx)

    testImplementation(Deps.Androidx.Test.core)
    testImplementation(Deps.Androidx.Test.runner)
    testImplementation(Deps.Androidx.Test.rules)
    testImplementation(Deps.Androidx.Test.junit)
    testImplementation(Deps.Androidx.Test.truth)
}
