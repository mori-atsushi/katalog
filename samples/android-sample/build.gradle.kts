plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = Constants.compileSdk
    buildToolsVersion = Constants.buildToolsVersion

    defaultConfig {
        applicationId = "jp.co.cyberagent.katalog.android_sample"
        minSdk = Constants.minSdk
        targetSdk = Constants.targetSdk
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(project(":katalog"))
}