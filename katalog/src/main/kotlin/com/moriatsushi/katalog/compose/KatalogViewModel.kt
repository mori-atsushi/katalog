package com.moriatsushi.katalog.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moriatsushi.katalog.compose.navigation.MainDestination
import com.moriatsushi.katalog.compose.navigation.NavController
import com.moriatsushi.katalog.compose.navigation.createMainNavController
import com.moriatsushi.katalog.compose.navigation.navigateTo
import com.moriatsushi.katalog.domain.CatalogItem
import com.moriatsushi.katalog.domain.Katalog
import com.moriatsushi.katalog.domain.KatalogContainer
import com.moriatsushi.katalog.domain.NotRegisteredException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class KatalogViewModel(
    private val container: KatalogContainer = KatalogContainer.instance,
) : ViewModel() {
    private val _katalog = MutableStateFlow<Katalog?>(null)
    val katalog: StateFlow<Katalog?> = _katalog

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    val navController: NavController<MainDestination> =
        createMainNavController()

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
        navController.navigateTo(item)
    }
}
