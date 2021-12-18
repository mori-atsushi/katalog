package jp.co.cyberagent.katalog.compose.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import jp.co.cyberagent.katalog.compose.util.rememberIsTop
import jp.co.cyberagent.katalog.compose.widget.CatalogItemList
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog

@Composable
internal fun GroupPage(
    katalog: Katalog,
    group: CatalogItem.Group,
    onChangeIsTop: (isTop: Boolean) -> Unit = {},
    onClickItem: (item: CatalogItem) -> Unit
) {
    val extensions = katalog.extensions
    val lazyListState = rememberLazyListState()
    val isTop by lazyListState.rememberIsTop()
    LaunchedEffect(isTop) {
        onChangeIsTop(isTop)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        CatalogItemList(
            list = group.items,
            extensions = extensions,
            onClick = onClickItem,
            lazyListState = lazyListState
        )
    }
}
