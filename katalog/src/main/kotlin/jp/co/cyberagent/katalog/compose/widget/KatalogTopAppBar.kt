package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
internal fun KatalogTopAppBar(
    title: String,
    navigationIcon: @Composable (() -> Unit)? = null,
) {
    Column {
        TopAppBar(
            title = { Text(text = title) },
            elevation = 0.dp,
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground,
            navigationIcon = navigationIcon
        )
        Divider(
            color = MaterialTheme.colors.surface
        )
    }
}
