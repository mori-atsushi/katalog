plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
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
        freeCompilerArgs = freeCompilerArgs + "-Xexplicit-api=strict"
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
    implementation(kotlin("stdlib"))
    implementation(Deps.KotlinX.Coroutines.android)

    implementation(Deps.Androidx.Activity.ktx)
    implementation(Deps.Androidx.Activity.compose)
    implementation(Deps.Androidx.Fragment.ktx)

    implementation(Deps.Androidx.Compose.ui)
    implementation(Deps.Androidx.Compose.uiTooling)
    implementation(Deps.Androidx.Compose.foundation)
    implementation(Deps.Androidx.Compose.material)

    implementation(Deps.Androidx.Lifecycle.viewModel)
    implementation(Deps.Androidx.Lifecycle.compose)

    implementation(Deps.Androidx.annotation)

    implementation(Deps.material)

    testImplementation(Deps.Androidx.Test.core)
    testImplementation(Deps.Androidx.Test.runner)
    testImplementation(Deps.Androidx.Test.rules)
    testImplementation(Deps.Androidx.Test.junit)
    testImplementation(Deps.Androidx.Test.truth)
}
