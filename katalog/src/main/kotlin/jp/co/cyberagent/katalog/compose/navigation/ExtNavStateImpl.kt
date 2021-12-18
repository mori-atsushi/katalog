package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import jp.co.cyberagent.katalog.domain.Katalog
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first

@OptIn(ExperimentalKatalogExtApi::class)
internal class ExtNavStateImpl(
    private val navController: NavController<MainDestination>,
    private val katalog: StateFlow<Katalog?>
) : ExtNavState {
    override val current: String by derivedStateOf {
        backStack.last()
    }
    override val backStack: List<String> by derivedStateOf {
        getBackStack(navController)
    }

    override suspend fun navigateTo(destination: String): Boolean {
        val item = getKatalog().findItemById(destination, ignoreCount = true)
        if (item != null) {
            navController.navigateTo(item)
            return true
        }
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

    private suspend fun getKatalog(): Katalog {
        return katalog.filterNotNull().first()
    }
}
