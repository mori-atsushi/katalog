package jp.co.cyberagent.katalog.compose.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import jp.co.cyberagent.katalog.compose.KatalogViewModel
import jp.co.cyberagent.katalog.compose.util.rememberIsTop
import jp.co.cyberagent.katalog.compose.widget.CatalogItemList
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun GroupPage(
    viewModel: KatalogViewModel,
    group: CatalogItem.Group,
    onChangeIsTop: (Boolean) -> Unit = {}
) {
    val katalog by viewModel.katalog.collectAsState()
    val extensions = katalog?.extensions ?: return
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
            onClick = viewModel::handleClick,
            lazyListState = lazyListState
        )
    }
}
