plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.publish)
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-Xexplicit-api=strict",
            "-Xopt-in=kotlin.RequiresOptIn"
        )
    }
    composeOptions {
        kotlinCompilerExtensionVersion =
            libs.versions.androidx.compose.compiler.get()
    }
    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
        getByName("test").java.srcDir("src/test/kotlin")
        getByName("androidTest").java.srcDir("src/androidTest/kotlin")
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "com.moriatsushi.katalog"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.core)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material.icons.core)
    implementation(libs.androidx.compose.material.icons.extended)

    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.androidx.annotation)

    implementation(libs.material)

    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.test.runner)
    testImplementation(libs.androidx.test.rules)
    testImplementation(libs.androidx.test.ext.junit)
    testImplementation(libs.androidx.test.ext.truth)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.androidx.compose.ui.test)
    testImplementation(libs.androidx.compose.ui.test.manifest)
    testImplementation(libs.robolectric)
}
