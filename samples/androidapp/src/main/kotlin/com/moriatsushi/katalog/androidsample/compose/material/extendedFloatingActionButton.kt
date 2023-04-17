package com.moriatsushi.katalog.androidsample.compose.material

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SampleExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        text = { Text("ADD TO BASKET") },
        onClick = { /*do something*/ }
    )
}

@Composable
fun SampleExtendedFloatingActionButtonFullWidth() {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        text = { Text("FLUID FAB") },
        onClick = { /*do something*/ },
        modifier = Modifier.fillMaxWidth()
    )
}
