package jp.co.cyberagent.katalog.compose.page

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.compose.navigation.MainDestination
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.NavRoot
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog

@Composable
internal fun MainPage(
    katalog: Katalog,
    navController: NavController<MainDestination>,
    onClickItem: (item: CatalogItem) -> Unit
) {
    NavRoot(navController) { state ->
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
