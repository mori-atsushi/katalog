package jp.co.cyberagent.katalog.compose.page

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.compose.widget.CatalogItemList
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun GroupPage(
    group: CatalogItem.Group,
    onClick: (CatalogItem) -> Unit
) {
    CatalogItemList(
        list = group.items,
        onClick = onClick
    )
}
