package jp.co.cyberagent.katalog.compose.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import jp.co.cyberagent.katalog.compose.KatalogViewModel
import jp.co.cyberagent.katalog.compose.widget.Preview
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun PreviewPage(
    viewModel: KatalogViewModel,
    component: CatalogItem.Component
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Preview(
            modifier = Modifier.fillMaxSize(),
            definition = component.definition
        )
    }
}
