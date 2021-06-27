package jp.co.cyberagent.katalog.compose

import android.view.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.co.cyberagent.katalog.compose.navigation.NavDestination
import jp.co.cyberagent.katalog.compose.navigation.NavRoot
import jp.co.cyberagent.katalog.compose.page.GroupPage
import jp.co.cyberagent.katalog.compose.page.TopPage
import jp.co.cyberagent.katalog.compose.res.materialColors
import jp.co.cyberagent.katalog.compose.util.FragmentManagerProvider

@Composable
internal fun App(
    window: Window,
    fragmentManager: FragmentManager,
    viewModel: KatalogViewModel = viewModel()
) {
    val darkTheme = isSystemInDarkTheme()
    val catalog by viewModel.katalog.collectAsState()

    FragmentManagerProvider(fragmentManager) {
        MaterialTheme(
            colors = materialColors(darkTheme)
        ) {
            AppWindow(
                window = window,
                darkTheme = darkTheme
            )
            MainContent(
                viewModel = viewModel
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
    window.statusBarColor = MaterialTheme.colors.surface.toArgb()
    val controller = WindowInsetsControllerCompat(window, view)
    controller.isAppearanceLightNavigationBars = !darkTheme
    controller.isAppearanceLightStatusBars = !darkTheme
}

@Composable
private fun MainContent(viewModel: KatalogViewModel) {
    val katalog by viewModel.katalog.collectAsState()
    val navController = viewModel.navController

    Column {
        TopAppBar(
            title = { Text(text = katalog?.title.orEmpty()) },
            elevation = 0.dp,
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.onSurface
        )
        NavRoot(navController) {
            Box(
                modifier = Modifier.background(MaterialTheme.colors.background)
            ) {
                when (it) {
                    is NavDestination.Top -> {
                        TopPage(
                            katalog = katalog,
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
