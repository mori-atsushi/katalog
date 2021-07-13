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
            "-Xexplicit-api=strict",
            "-Xopt-in=kotlin.RequiresOptIn"
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
    implementation(kotlin("stdlib"))
    implementation(Deps.KotlinX.Coroutines.android)

    implementation(Deps.Androidx.Activity.ktx)
    implementation(Deps.Androidx.Activity.compose)
    implementation(Deps.Androidx.Fragment.ktx)

    implementation(Deps.Androidx.Compose.ui)
    implementation(Deps.Androidx.Compose.uiTooling)
    implementation(Deps.Androidx.Compose.foundation)
    implementation(Deps.Androidx.Compose.material)
    implementation(Deps.Androidx.Compose.materialIconsCore)
    implementation(Deps.Androidx.Compose.materialIconExtended)

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

val sourceJar by tasks.creating(Jar::class) {
    from(android.sourceSets.getByName("main").java.srcDirs)
    archiveClassifier.set("sources")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            val commitHash = project.findProperty("commit_hash") as? String
                ?: System.getenv("GIT_COMMIT_HASH")
            groupId = "co.jp.cyberagent.katalog"
            artifactId = "katalog-android"
            version = "${Constants.version}-$commitHash-SNAPSHOT"
            artifact(sourceJar)
            artifact("$buildDir/outputs/aar/katalog-release.aar")

            pom.withXml {
                val dependenciesNode = asNode().appendNode("dependencies")

                project.configurations.implementation.get().allDependencies.forEach {
                    val dependencyNode = dependenciesNode.appendNode("dependency")
                    dependencyNode.appendNode("groupId", it.group)
                    dependencyNode.appendNode("artifactId", it.name)
                    dependencyNode.appendNode("version", it.version)
                }
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/cyberagent-zemi/katalog")
            credentials {
                username = project.findProperty("gpr.user") as? String
                    ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.token") as? String
                    ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
