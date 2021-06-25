package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun CatalogItemList(
    list: List<CatalogItem>,
    onClick: (item: CatalogItem) -> Unit
) {
    if (list.isEmpty()) {
        Empty()
        return
    }
    LazyColumn {
        items(list) {
            CatalogItemRow(
                item = it,
                onClick = onClick
            )
        }
    }
}
