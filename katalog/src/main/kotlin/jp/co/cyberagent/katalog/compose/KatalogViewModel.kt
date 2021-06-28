package jp.co.cyberagent.katalog.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.NavDestination
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class KatalogViewModel : ViewModel() {
    private val _katalog = MutableStateFlow<Katalog?>(null)
    val katalog: StateFlow<Katalog?> = _katalog

    private val _selectedComponent = MutableStateFlow<CatalogItem.Component?>(null)
    val selectedComponent: StateFlow<CatalogItem.Component?> = _selectedComponent

    val navController = NavController<NavDestination>(NavDestination.Top)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            val catalog = Katalog.create()
            _katalog.value = catalog
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
}
