package jp.co.cyberagent.katalog.compose.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import jp.co.cyberagent.katalog.compose.widget.KatalogTopAppBar
import jp.co.cyberagent.katalog.compose.widget.Preview
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Extensions

@Composable
internal fun PreviewPage(
    component: CatalogItem.Component,
    extensions: Extensions,
    onClickClose: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        PreviewTopAppBar(
            name = component.name,
            onClickClose = onClickClose
        )
        Preview(
            extensions = extensions,
            modifier = Modifier.fillMaxSize(),
            clickable = true,
            definition = component.definition
        )
    }
}

@Composable
private fun PreviewTopAppBar(
    name: String,
    onClickClose: () -> Unit
) {
    KatalogTopAppBar(
        title = name,
        navigationIcon = {
            IconButton(onClick = onClickClose) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "close"
                )
            }
        }
    )
}
