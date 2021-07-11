package jp.co.cyberagent.katalog.compose.page

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import jp.co.cyberagent.katalog.compose.KatalogViewModel
import jp.co.cyberagent.katalog.compose.navigation.NavDestination
import jp.co.cyberagent.katalog.compose.navigation.NavRoot
import jp.co.cyberagent.katalog.compose.widget.KatalogTopAppBar

@Composable
internal fun DiscoveryPage(
    viewModel: KatalogViewModel
) {
    val katalog by viewModel.katalog.collectAsState()
    val navController = viewModel.navController

    Scaffold(
        topBar = {
            KatalogTopAppBar(
                title = katalog?.title.orEmpty()
            )
        }
    ) {
        NavRoot(navController) {
            Box {
                when (it) {
                    is NavDestination.Top -> {
                        TopPage(
                            katalog = katalog,
                            onClick = viewModel::handleClick
                        )
                    }
                    is NavDestination.Group -> {
                        GroupPage(
                            group = it.group,
                            onClick = viewModel::handleClick
                        )
                    }
                }
            }
        }
    }
}
