package com.moriatsushi.katalog.compose.page

import androidx.compose.runtime.Composable
import com.moriatsushi.katalog.compose.navigation.MainDestination
import com.moriatsushi.katalog.compose.navigation.NavAnimation
import com.moriatsushi.katalog.compose.navigation.NavController
import com.moriatsushi.katalog.compose.navigation.NavRoot
import com.moriatsushi.katalog.domain.CatalogItem
import com.moriatsushi.katalog.domain.Katalog
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
@Composable
internal fun MainPage(
    katalog: Katalog,
    navController: NavController<MainDestination>,
    extNavState: ExtNavState,
    onClickItem: (item: CatalogItem) -> Unit,
    onClickBack: () -> Unit
) {
    NavRoot(
        navController = navController,
        transitionSpec = NavAnimation.createUpSpec()
    ) { state ->
        when (state.destination) {
            is MainDestination.Discovery -> {
                DiscoveryPage(
                    katalog = katalog,
                    navController = state.destination.childNavController,
                    extNavState = extNavState,
                    onClickItem = onClickItem,
                    isTopPage = navController.isTop,
                    onClickBack = onClickBack
                )
            }
            is MainDestination.Preview -> {
                PreviewPage(
                    component = state.destination.component,
                    extensions = katalog.extensions,
                    extNavState = extNavState,
                    onClickClose = onClickBack
                )
            }
        }
    }
}
