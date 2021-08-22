package jp.co.cyberagent.katalog.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.NavDestination
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
    private val _katalog = MutableStateFlow<Katalog?>(null)
    val katalog: StateFlow<Katalog?> = _katalog

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _selectedComponent = MutableStateFlow<CatalogItem.Component?>(null)
    val selectedComponent: StateFlow<CatalogItem.Component?> = _selectedComponent

    val navController = NavController<NavDestination>(NavDestination.Top)

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
                navController.push(NavDestination.Group(item))
            }
            is CatalogItem.Component -> {
                _selectedComponent.value = item
            }
        }
    }

    fun handleBackPress(): Boolean {
        return if (_selectedComponent.value != null) {
            _selectedComponent.value = null
            true
        } else {
            navController.back()
        }
    }

    fun closePreview() {
        _selectedComponent.value = null
    }
}
