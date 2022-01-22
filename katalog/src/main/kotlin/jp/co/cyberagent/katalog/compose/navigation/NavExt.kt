package jp.co.cyberagent.katalog.compose.navigation

import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.CatalogItemIdentifier
import jp.co.cyberagent.katalog.domain.Katalog

internal fun createMainNavController(): NavController<MainDestination> {
    val initialDestination = MainDestination.Discovery(
        childNavController = NavController(DiscoveryDestination.Top)
    )
    return NavController(initialDestination)
}

internal fun NavController<MainDestination>.navigateTo(
    katalog: Katalog,
    id: String
): Boolean {
    if (id == CatalogItemIdentifier.rootId) {
        navigateToTop()
        return true
    }
    val item = katalog.findItemById(id, ignoreCount = true) ?: return false
    navigateTo(item)
    return true
}

internal fun NavController<MainDestination>.navigateTo(item: CatalogItem) {
    when (item) {
        is CatalogItem.Group -> {
            val nextChildDestination = DiscoveryDestination.Group(item)
            navigateTo(nextChildDestination)
        }
        is CatalogItem.Component -> {
            val nextDestination = MainDestination.Preview(
                component = item
            )
            push(nextDestination)
        }
    }
}

private fun NavController<MainDestination>.navigateToTop() {
    navigateTo(DiscoveryDestination.Top)
}

private fun NavController<MainDestination>.navigateTo(
    nextChildDestination: DiscoveryDestination
) {
    val currentDestination = current.destination
    if (currentDestination is MainDestination.Discovery) {
        currentDestination.childNavController.push(nextChildDestination)
    } else {
        val nextDestination = MainDestination.Discovery(
            childNavController = NavController(nextChildDestination)
        )
        push(nextDestination)
    }
}

internal fun NavController<MainDestination>.restore(
    katalog: Katalog,
    backStack: List<String>
): Boolean {
    val destinations = backStack.fold(listOf<MainDestination>()) { acc, it ->
        if (it == CatalogItemIdentifier.rootId) {
            val nextChildDestination = DiscoveryDestination.Top
            createDestinations(acc, nextChildDestination)
        } else {
            val item = katalog.findItemById(it, ignoreCount = true) ?: return false
            createDestinations(acc, item)
        }
    }
    restore(destinations)
    return true
}

private fun createDestinations(
    current: List<MainDestination>,
    item: CatalogItem
): List<MainDestination> {
    return when (item) {
        is CatalogItem.Group -> {
            val nextChildDestination = DiscoveryDestination.Group(item)
            createDestinations(current, nextChildDestination)
        }
        is CatalogItem.Component -> {
            val nextDestination = MainDestination.Preview(
                component = item
            )
            current + nextDestination
        }
    }
}

private fun createDestinations(
    current: List<MainDestination>,
    nextChildDestination: DiscoveryDestination
): List<MainDestination> {
    val currentDestination = current.lastOrNull()
    return if (currentDestination is MainDestination.Discovery) {
        currentDestination.childNavController.push(nextChildDestination)
        current
    } else {
        val nextDestination = MainDestination.Discovery(
            childNavController = NavController(nextChildDestination)
        )
        current + nextDestination
    }
}

internal val NavController<MainDestination>.idBackStack: List<String>
    get() = backStack.flatMap {
        when (val destination = it.destination) {
            is MainDestination.Discovery -> {
                destination.childNavController.childIdBackStack
            }
            is MainDestination.Preview -> {
                listOf(destination.component.id)
            }
        }
    }

private val NavController<DiscoveryDestination>.childIdBackStack: List<String>
    get() = backStack.map {
        when (val childDestination = it.destination) {
            is DiscoveryDestination.Group -> childDestination.group.id
            is DiscoveryDestination.Top -> CatalogItemIdentifier.rootId
        }
    }
