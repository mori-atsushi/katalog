package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import jp.co.cyberagent.katalog.domain.Katalog
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
internal class ExtNavStateImpl(
    private val navController: NavController<MainDestination>,
    private val katalog: Katalog
) : ExtNavState {
    override val current: String by derivedStateOf {
        backStack.last()
    }
    override val backStack: List<String> by derivedStateOf {
        navController.idBackStack
    }

    override fun navigateTo(destination: String): Boolean {
        return navController.navigateTo(katalog, destination)
    }

    override fun restore(backStack: List<String>): Boolean {
        return navController.restore(katalog, backStack)
    }
}

@ExperimentalKatalogExtApi
@Composable
internal fun rememberExtNavState(
    navController: NavController<MainDestination>,
    katalog: Katalog
): ExtNavState {
    return remember(navController, katalog) {
        ExtNavStateImpl(
            navController = navController,
            katalog = katalog
        )
    }
}
