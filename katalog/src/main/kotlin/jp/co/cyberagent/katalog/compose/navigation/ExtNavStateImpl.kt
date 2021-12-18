package jp.co.cyberagent.katalog.compose.navigation

import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState

@OptIn(ExperimentalKatalogExtApi::class)
internal class ExtNavStateImpl(
    override val current: String,
    override val backStack: List<String>,
    private val navigateTo: (destination: String) -> Boolean,
    private val restore: (current: String, backStack: List<String>) -> Boolean
) : ExtNavState {
    override suspend fun navigateTo(destination: String): Boolean {
        return navigateTo.invoke(destination)
    }

    override suspend fun restore(current: String, backStack: List<String>): Boolean {
        return restore.invoke(current, backStack)
    }
}
