package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState

@OptIn(ExperimentalKatalogExtApi::class)
internal class ExtNavStateImpl(
    private val navController: NavController<MainDestination>
) : ExtNavState {
    override val current: String by derivedStateOf {
        backStack.last()
    }
    override val backStack: List<String> by derivedStateOf {
        getBackStack(navController)
    }

    override suspend fun navigateTo(destination: String): Boolean {
        return false
    }

    override suspend fun restore(current: String, backStack: List<String>): Boolean {
        return false
    }

    private fun getBackStack(navController: NavController<MainDestination>): List<String> {
        return navController.backStack.flatMap {
            when (val destination = it.destination) {
                is MainDestination.Discovery -> {
                    getChildBackStack(destination.childNavController)
                }
                is MainDestination.Preview -> {
                    listOf(destination.component.id)
                }
            }
        }
    }

    private fun getChildBackStack(navController: NavController<DiscoveryDestination>): List<String> {
        return navController.backStack.map {
            when (val childDestination = it.destination) {
                is DiscoveryDestination.Group -> childDestination.group.id
                is DiscoveryDestination.Top -> "/"
            }
        }
    }
}
