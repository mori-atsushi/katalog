package jp.co.cyberagent.katalog.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.DiscoveryDestination
import jp.co.cyberagent.katalog.compose.navigation.MainDestination
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog
import jp.co.cyberagent.katalog.domain.KatalogContainer
import jp.co.cyberagent.katalog.domain.NotRegisteredException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class KatalogViewModel(
    private val container: KatalogContainer = KatalogContainer.instance
) : ViewModel() {
    companion object {
        val initialDestination = MainDestination.Discovery(
            childNavController = NavController(DiscoveryDestination.Top)
        )
    }

    private val _katalog = MutableStateFlow<Katalog?>(null)
    val katalog: StateFlow<Katalog?> = _katalog

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    val navController: NavController<MainDestination> = NavController(initialDestination)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val katalog = container.create()
                _katalog.value = katalog
            } catch (e: NotRegisteredException) {
                _errorMessage.value = "Please call registerKatalog method."
            } catch (e: Throwable) {
                _errorMessage.value = "Unknown error: $e"
            }
        }
    }

    fun handleClick(item: CatalogItem) {
        when (item) {
            is CatalogItem.Group -> {
                val currentDestination = navController.current.value.destination
                val nextChildDestination = DiscoveryDestination.Group(item)
                if (currentDestination is MainDestination.Discovery) {
                    currentDestination.childNavController.push(nextChildDestination)
                } else {
                    val nextDestination = MainDestination.Discovery(
                        childNavController = NavController(nextChildDestination)
                    )
                    navController.push(nextDestination)
                }
            }
            is CatalogItem.Component -> {
                val nextDestination = MainDestination.Preview(
                    component = item
                )
                navController.push(nextDestination)
            }
        }
    }

    fun handleBackPress(): Boolean {
        return navController.back()
    }

    fun closePreview() {
        val currentDestination = navController.current.value.destination
        if (currentDestination is MainDestination.Preview) {
            navController.back()
        }
    }
}
