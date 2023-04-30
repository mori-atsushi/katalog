package com.moriatsushi.katalog.androidsample.compose.material

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SampleSurface() {
    Surface(
        color = MaterialTheme.colors.background,
    ) {
        Text("Text color is `onBackground`")
    }
}
