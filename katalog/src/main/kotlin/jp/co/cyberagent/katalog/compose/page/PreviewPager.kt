package jp.co.cyberagent.katalog.compose.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.cyberagent.katalog.compose.KatalogViewModel
import jp.co.cyberagent.katalog.compose.util.BackPressedEffect
import jp.co.cyberagent.katalog.compose.widget.Preview
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun PreviewPage(
    viewModel: KatalogViewModel,
    component: CatalogItem.Component
) {
    BackPressedEffect(component) {
        viewModel.closePreview()
        true
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        PreviewTopAppBar(
            name = component.name,
            onClickClose = viewModel::closePreview
        )
        Preview(
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
    TopAppBar(
        title = { Text(name) },
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        navigationIcon = {
            IconButton(onClick = onClickClose) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "close"
                )
            }
        },
        elevation = 0.dp
    )
}
