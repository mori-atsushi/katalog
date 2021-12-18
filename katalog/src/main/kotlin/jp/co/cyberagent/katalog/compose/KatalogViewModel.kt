package jp.co.cyberagent.katalog.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.cyberagent.katalog.compose.navigation.ExtNavStateImpl
import jp.co.cyberagent.katalog.compose.navigation.MainDestination
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.createMainNavController
import jp.co.cyberagent.katalog.compose.navigation.navigateTo
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.Katalog
import jp.co.cyberagent.katalog.domain.KatalogContainer
import jp.co.cyberagent.katalog.domain.NotRegisteredException
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalKatalogExtApi::class)
internal class KatalogViewModel(
    private val container: KatalogContainer = KatalogContainer.instance
) : ViewModel() {
    private val _katalog = MutableStateFlow<Katalog?>(null)
    val katalog: StateFlow<Katalog?> = _katalog

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    val navController: NavController<MainDestination> =
        createMainNavController()

    private val extNavState: ExtNavState = ExtNavStateImpl(
        navController = navController,
        katalog = katalog
    )

    init {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val katalog = container.create(extNavState)
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
