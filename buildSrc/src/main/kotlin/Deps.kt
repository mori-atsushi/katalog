object Deps {
    object KotlinX {
        object Coroutines {
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KotlinX.coroutines}"
            const val test =
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KotlinX.coroutines}"
        }

        object Serialization {
            const val json =
                "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KotlinX.serialization}"
        }
    }

    object Androidx {
        object Core {
            const val ktx =
                "androidx.core:core-ktx:${Versions.Androidx.ktx}"
        }

        object Activity {
            const val ktx =
                "androidx.activity:activity-ktx:${Versions.Androidx.activity}"
            const val compose =
                "androidx.activity:activity-compose:${Versions.Androidx.activity}"
        }

        object Fragment {
            const val ktx =
                "androidx.fragment:fragment-ktx:${Versions.Androidx.fragment}"
        }

        object Compose {
            const val ui =
                "androidx.compose.ui:ui:${Versions.Androidx.compose}"
            const val uiTooling =
                "androidx.compose.ui:ui-tooling:${Versions.Androidx.compose}"
            const val foundation =
                "androidx.compose.foundation:foundation:${Versions.Androidx.compose}"
            const val material =
                "androidx.compose.material:material:${Versions.Androidx.compose}"
            const val materialIconsCore =
                "androidx.compose.material:material-icons-core:${Versions.Androidx.compose}"
            const val materialIconExtended =
                "androidx.compose.material:material-icons-extended:${Versions.Androidx.compose}"
            const val uiTest =
                "androidx.compose.ui:ui-test-junit4:${Versions.Androidx.compose}"
            const val uiTestManifest =
                "androidx.compose.ui:ui-test-manifest:${Versions.Androidx.compose}"
        }

        object Lifecycle {
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.lifecycle}"
            const val runtime =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Androidx.lifecycle}"
            const val compose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Androidx.lifecycle}"
        }

        const val annotation = "androidx.annotation:annotation:${Versions.Androidx.annotation}"

        object Test {
            const val core =
                "androidx.test:core-ktx:${Versions.Androidx.Test.core}"
            const val runner =
                "androidx.test:runner:${Versions.Androidx.Test.runner}"
            const val rules =
                "androidx.test:rules:${Versions.Androidx.Test.rules}"
            const val junit =
                "androidx.test.ext:junit-ktx:${Versions.Androidx.Test.junit}"
            const val truth =
                "androidx.test.ext:truth:${Versions.Androidx.Test.truth}"
        }
    }

    const val material = "com.google.android.material:material:${Versions.material}"
    const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
}
