package com.moriatsushi.katalog.androidsample

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun SampleTheme(
    content: @Composable () -> Unit
) {
    val darkTheme = isSystemInDarkTheme()
    MaterialTheme(
        colors = if (darkTheme) darkColors() else lightColors(),
        content = content
    )
}
