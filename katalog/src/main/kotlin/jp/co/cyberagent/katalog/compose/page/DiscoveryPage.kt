package jp.co.cyberagent.katalog.compose.page

import androidx.compose.animation.ExperimentalAnimationApi
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
import jp.co.cyberagent.katalog.compose.navigation.DiscoveryDestination
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.NavRoot
import jp.co.cyberagent.katalog.compose.widget.KatalogTopAppBar
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun DiscoveryPage(
    katalog: Katalog,
    navController: NavController<DiscoveryDestination>,
    onClickItem: (item: CatalogItem) -> Unit
) {
    val isPageTop = navController.isTop
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
                isPageTop = isPageTop,
                isScrollTop = isScrollTop,
                onClickBack = { navController.back() }
            )
        }
    ) {
        NavRoot(navController) { state ->
            DiscoveryPageSelector(
                destination = state.destination,
                katalog = katalog,
                onChangeIsTop = {
                    if (navController.current == state) {
                        isScrollTop = it
                    }
                },
                onClickItem = onClickItem
            )
        }
    }
}

@Composable
private fun DiscoveryTopAppBar(
    title: String,
    isPageTop: Boolean,
    isScrollTop: Boolean,
    onClickBack: () -> Unit
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
                        contentDescription = "back"
                    )
                }
            }
        }
    )
}

@Composable
private fun DiscoveryPageSelector(
    destination: DiscoveryDestination,
    katalog: Katalog,
    onChangeIsTop: (Boolean) -> Unit,
    onClickItem: (item: CatalogItem) -> Unit
) {
    when (destination) {
        is DiscoveryDestination.Top -> {
            TopPage(
                katalog = katalog,
                onChangeIsTop = onChangeIsTop,
                onClickItem = onClickItem
            )
        }
        is DiscoveryDestination.Group -> {
            GroupPage(
                katalog = katalog,
                group = destination.group,
                onChangeIsTop = onChangeIsTop,
                onClickItem = onClickItem
            )
        }
    }
}
