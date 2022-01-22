package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.runtime.Stable

@Stable
internal interface NavDestination {
    val childNavController: NavController<*>? get() = null
}
