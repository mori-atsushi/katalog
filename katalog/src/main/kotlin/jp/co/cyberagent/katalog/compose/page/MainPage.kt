package jp.co.cyberagent.katalog.compose.page

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.compose.navigation.MainDestination
import jp.co.cyberagent.katalog.compose.navigation.NavAnimation
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.NavRoot
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun MainPage(
    katalog: Katalog,
    navController: NavController<MainDestination>,
    onClickItem: (item: CatalogItem) -> Unit
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
                    onClickItem = onClickItem
                )
            }
            is MainDestination.Preview -> {
                PreviewPage(
                    component = state.destination.component,
                    extensions = katalog.extensions,
                    onClickClose = navController::back
                )
            }
        }
    }
}
