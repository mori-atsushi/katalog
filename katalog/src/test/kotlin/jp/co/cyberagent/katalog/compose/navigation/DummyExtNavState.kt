package jp.co.cyberagent.katalog.compose.navigation

import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
internal class DummyExtNavState : ExtNavState {
    override val current: String
        get() = "/"
    override val backStack: List<String>
        get() = listOf("/")

    override suspend fun navigateTo(destination: String): Boolean {
        return false
    }

    override suspend fun restore(current: String, backStack: List<String>): Boolean {
        return false
    }
}
