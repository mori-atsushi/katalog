package jp.co.cyberagent.katalog.compose.page

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.compose.navigation.NavController
import jp.co.cyberagent.katalog.compose.navigation.NavDestination
import jp.co.cyberagent.katalog.compose.widget.CatalogItemList
import jp.co.cyberagent.katalog.domain.CatalogItem

@Composable
internal fun GroupPage(
    group: CatalogItem.Group,
    navController: NavController<NavDestination>
) {
    CatalogItemList(
        list = group.items,
        onClick = {
            if (it is CatalogItem.Group) {
                navController.push(NavDestination.Group(it))
            }
        }
    )
}
