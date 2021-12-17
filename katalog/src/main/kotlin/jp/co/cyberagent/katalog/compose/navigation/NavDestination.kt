package jp.co.cyberagent.katalog.compose.navigation

internal interface NavDestination {
    val childNavController: NavController<*>? get() = null
}
