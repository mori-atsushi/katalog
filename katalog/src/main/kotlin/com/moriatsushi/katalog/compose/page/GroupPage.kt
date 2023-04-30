package com.moriatsushi.katalog.compose.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.moriatsushi.katalog.compose.util.rememberIsTop
import com.moriatsushi.katalog.compose.widget.CatalogItemList
import com.moriatsushi.katalog.domain.CatalogItem
import com.moriatsushi.katalog.domain.Katalog
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
@Composable
internal fun GroupPage(
    katalog: Katalog,
    group: CatalogItem.Group,
    extNavState: ExtNavState,
    onChangeIsTop: (isTop: Boolean) -> Unit = {},
    onClickItem: (item: CatalogItem) -> Unit,
) {
    val extensions = katalog.extensions
    val lazyListState = rememberLazyListState()
    val isTop by lazyListState.rememberIsTop()
    LaunchedEffect(isTop) {
        onChangeIsTop(isTop)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
    ) {
        CatalogItemList(
            list = group.items,
            extensions = extensions,
            extNavState = extNavState,
            onClick = onClickItem,
            lazyListState = lazyListState,
        )
    }
}
