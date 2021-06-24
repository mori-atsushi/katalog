object Deps {
    object KotlinX {
        object Coroutines {
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KotlinX.coroutines}"
        }
    }

    object Androidx {
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
            const val activity =
                "androidx.activity:activity-compose:${Versions.Androidx.activity}"
        }

        object Lifecycle {
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.lifecycle}"
            const val compose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Androidx.lifecycleCompose}"
        }

        const val annotation = "androidx.annotation:annotation:${Versions.Androidx.annotation}"
    }

    const val material = "com.google.android.material:material:${Versions.material}"
    const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"
}
