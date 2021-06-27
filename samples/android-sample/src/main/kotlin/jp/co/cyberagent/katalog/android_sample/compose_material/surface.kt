package jp.co.cyberagent.katalog.android_sample.compose_material

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SampleSurface() {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Text("Text color is `onBackground`")
    }
}
