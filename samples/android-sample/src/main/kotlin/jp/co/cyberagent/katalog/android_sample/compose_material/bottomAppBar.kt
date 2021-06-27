package jp.co.cyberagent.katalog.android_sample.compose_material

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SampleBottomAppBar() {
    BottomAppBar {
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Menu, contentDescription = "Localized description")
        }
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
        }
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
        }
    }
}
