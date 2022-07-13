package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Extensions
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
@Composable
internal fun CatalogItemList(
    title: String,
    list: List<CatalogItem>,
    extensions: Extensions,
    extNavState: ExtNavState,
    onClick: (item: CatalogItem) -> Unit,
    lazyListState: LazyListState = rememberLazyListState()
) {
    if (list.isEmpty()) {
        Empty()
        return
    }

    LazyColumn(
        state = lazyListState
    ) {
        items(list) {
            CatalogItemRow(
                title = title,
                item = it,
                extensions = extensions,
                extNavState = extNavState,
                onClick = onClick
            )
        }
        item {
            LastItem()
        }
    }
}

@Composable
private fun LastItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(5.dp),
            imageVector = Icons.Filled.Circle,
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.3F)
        )
    }
}
