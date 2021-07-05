package jp.co.cyberagent.katalog.compose.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import jp.co.cyberagent.katalog.compose.widget.CatalogItemList
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun GroupPage(
    group: CatalogItem.Group,
    onClick: (CatalogItem) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        CatalogItemList(
            list = group.items,
            onClick = onClick
        )
    }
}
