package jp.co.cyberagent.katalog.androidsample.compose.material

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun SampleTextButton() {
    TextButton(onClick = { /* Do something! */ }) {
        Text("Text Button")
    }
}
