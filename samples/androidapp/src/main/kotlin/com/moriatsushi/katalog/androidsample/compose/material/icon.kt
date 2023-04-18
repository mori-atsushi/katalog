package com.moriatsushi.katalog.androidsample.compose.material

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable

@Composable
fun SampleIcon() {
    Icon(
        imageVector = Icons.Default.Call,
        contentDescription = "call"
    )
}
