package jp.co.cyberagent.katalog.compose

import android.view.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.co.cyberagent.katalog.compose.navigation.NavDestination
import jp.co.cyberagent.katalog.compose.navigation.NavRoot
import jp.co.cyberagent.katalog.compose.navigation.rememberNavController
import jp.co.cyberagent.katalog.compose.page.GroupPage
import jp.co.cyberagent.katalog.compose.page.TopPage
import jp.co.cyberagent.katalog.compose.res.materialColors
import jp.co.cyberagent.katalog.compose.util.FragmentManagerProvider
import jp.co.cyberagent.katalog.domain.Catalog

@Composable
internal fun App(
    window: Window,
    fragmentManager: FragmentManager,
    viewModel: CatalogViewModel = viewModel()
) {
    val darkTheme = isSystemInDarkTheme()
    val catalog = viewModel.catalog.collectAsState()

    FragmentManagerProvider(fragmentManager) {
        MaterialTheme(
            colors = materialColors(darkTheme)
        ) {
            AppWindow(
                window = window,
                darkTheme = darkTheme
            )
            MainContent(
                catalog = catalog.value
            )
        }
    }
}

@Composable
private fun AppWindow(
    window: Window,
    darkTheme: Boolean
) {
    val view = LocalView.current
    window.statusBarColor = MaterialTheme.colors.primarySurface.toArgb()
    val controller = WindowInsetsControllerCompat(window, view)
    controller.isAppearanceLightNavigationBars = !darkTheme
    controller.isAppearanceLightStatusBars = !darkTheme
}

@Composable
private fun MainContent(catalog: Catalog?) {
    val navController = rememberNavController<NavDestination>(NavDestination.Top)
    Column {
        TopAppBar(
            title = { Text(text = catalog?.title.orEmpty()) },
            elevation = 0.dp
        )
        NavRoot(navController) {
            Box(
                modifier = Modifier.background(MaterialTheme.colors.background)
            ) {
                when (it) {
                    is NavDestination.Top -> {
                        TopPage(
                            catalog = catalog,
                            navController = navController
                        )
                    }
                    is NavDestination.Group -> {
                        GroupPage(
                            group = it.group,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
