package jp.co.cyberagent.katalog.compose.page

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.compose.widget.CatalogItemList
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog

@Composable
internal fun TopPage(
    katalog: Katalog?,
    onClick: (CatalogItem) -> Unit
) {
    if (katalog == null) {
        return
    }
    CatalogItemList(
        list = katalog.items,
        onClick = onClick
    )
}
