package jp.co.cyberagent.katalog.androidsample.compose.material

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SampleSwitch() {
    var checkedState by remember { mutableStateOf(true) }
    Switch(
        checked = checkedState,
        onCheckedChange = { checkedState = it }
    )
}
