package jp.co.cyberagent.katalog.compose.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import jp.co.cyberagent.katalog.compose.util.rememberIsTop
import jp.co.cyberagent.katalog.compose.widget.CatalogItemList
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog

@Composable
internal fun TopPage(
    katalog: Katalog?,
    onClick: (CatalogItem) -> Unit,
    onChangeIsTop: (Boolean) -> Unit = {}
) {
    val lazyListState = rememberLazyListState()
    val isTop = lazyListState.rememberIsTop()
    LaunchedEffect(isTop) {
        onChangeIsTop(isTop)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        if (katalog != null) {
            CatalogItemList(
                list = katalog.items,
                onClick = onClick,
                lazyListState = lazyListState
            )
        }
    }
}
