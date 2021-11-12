package jp.co.cyberagent.katalog.androidsample.compose.material

import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SampleOutlinedButton() {
    OutlinedButton(onClick = { /* Do something! */ }) {
        Text("Outlined Button")
    }
}
