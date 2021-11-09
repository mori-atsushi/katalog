package jp.co.cyberagent.katalog.androidsample.compose.material

import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SampleCheckbox() {
    var checkedState by remember { mutableStateOf(true) }
    Checkbox(
        checked = checkedState,
        onCheckedChange = { checkedState = it }
    )
}
