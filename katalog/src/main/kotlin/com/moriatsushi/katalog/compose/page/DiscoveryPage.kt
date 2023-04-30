package com.moriatsushi.katalog.compose.page

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.moriatsushi.katalog.compose.navigation.DiscoveryDestination
import com.moriatsushi.katalog.compose.navigation.NavController
import com.moriatsushi.katalog.compose.navigation.NavRoot
import com.moriatsushi.katalog.compose.widget.KatalogTopAppBar
import com.moriatsushi.katalog.domain.CatalogItem
import com.moriatsushi.katalog.domain.Katalog
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
@Composable
internal fun DiscoveryPage(
    katalog: Katalog,
    isTopPage: Boolean,
    navController: NavController<DiscoveryDestination>,
    extNavState: ExtNavState,
    onClickItem: (item: CatalogItem) -> Unit,
    onClickBack: () -> Unit,
) {
    var isScrollTop by remember {
        mutableStateOf(true)
    }
    val title by derivedStateOf {
        when (val destination = navController.current.destination) {
            is DiscoveryDestination.Group -> destination.group.name
            is DiscoveryDestination.Top -> katalog.title
        }
    }

    Scaffold(
        topBar = {
            DiscoveryTopAppBar(
                title = title,
                isPageTop = isTopPage,
                isScrollTop = isScrollTop,
                onClickBack = onClickBack,
            )
        },
    ) {
        NavRoot(navController) { state ->
            DiscoveryPageSelector(
                destination = state.destination,
                katalog = katalog,
                extNavState = extNavState,
                onChangeIsTop = {
                    if (navController.current == state) {
                        isScrollTop = it
                    }
                },
                onClickItem = onClickItem,
            )
        }
    }
}

@Composable
private fun DiscoveryTopAppBar(
    title: String,
    isPageTop: Boolean,
    isScrollTop: Boolean,
    onClickBack: () -> Unit,
) {
    KatalogTopAppBar(
        title = title,
        isVisibleDivider = !isScrollTop,
        navigationIcon = if (isPageTop) {
            null
        } else {
            {
                IconButton(onClick = onClickBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                    )
                }
            }
        },
    )
}

@ExperimentalKatalogExtApi
@Composable
private fun DiscoveryPageSelector(
    destination: DiscoveryDestination,
    katalog: Katalog,
    extNavState: ExtNavState,
    onChangeIsTop: (Boolean) -> Unit,
    onClickItem: (item: CatalogItem) -> Unit,
) {
    when (destination) {
        is DiscoveryDestination.Top -> {
            TopPage(
                katalog = katalog,
                extNavState = extNavState,
                onChangeIsTop = onChangeIsTop,
                onClickItem = onClickItem,
            )
        }
        is DiscoveryDestination.Group -> {
            GroupPage(
                katalog = katalog,
                group = destination.group,
                extNavState = extNavState,
                onChangeIsTop = onChangeIsTop,
                onClickItem = onClickItem,
            )
        }
    }
}
