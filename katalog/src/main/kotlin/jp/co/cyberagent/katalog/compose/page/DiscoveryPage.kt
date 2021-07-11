package jp.co.cyberagent.katalog.compose.page

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import jp.co.cyberagent.katalog.compose.KatalogViewModel
import jp.co.cyberagent.katalog.compose.navigation.NavDestination
import jp.co.cyberagent.katalog.compose.navigation.NavRoot
import jp.co.cyberagent.katalog.compose.widget.KatalogTopAppBar
import jp.co.cyberagent.katalog.domain.Katalog

@Composable
internal fun DiscoveryPage(
    viewModel: KatalogViewModel
) {
    val katalog by viewModel.katalog.collectAsState()
    val navController = viewModel.navController
    val isPageTop by navController.isTop
    var isScrollTop by remember {
        mutableStateOf(true)
    }
    val title by derivedStateOf {
        when (val destination = navController.current.value.destination) {
            is NavDestination.Group -> destination.group.name
            is NavDestination.Top -> katalog?.title.orEmpty()
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
                viewModel = viewModel,
                onChangeIsTop = {
                    if (navController.current.value == state) {
                        isScrollTop = it
                    }
                }
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
    destination: NavDestination,
    katalog: Katalog?,
    viewModel: KatalogViewModel,
    onChangeIsTop: (Boolean) -> Unit
) {
    when (destination) {
        is NavDestination.Top -> {
            TopPage(
                katalog = katalog,
                onClick = viewModel::handleClick,
                onChangeIsTop = onChangeIsTop
            )
        }
        is NavDestination.Group -> {
            GroupPage(
                group = destination.group,
                onClick = viewModel::handleClick,
                onChangeIsTop = onChangeIsTop
            )
        }
    }
}
