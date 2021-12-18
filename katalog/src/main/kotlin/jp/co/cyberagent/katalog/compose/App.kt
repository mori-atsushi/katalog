package jp.co.cyberagent.katalog.compose

import android.view.Window
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.co.cyberagent.katalog.compose.page.MainPage
import jp.co.cyberagent.katalog.compose.res.materialColors
import jp.co.cyberagent.katalog.compose.widget.ErrorMessage
import jp.co.cyberagent.katalog.domain.Extensions
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtRootWrapper

@Composable
internal fun App(
    window: Window,
    viewModel: KatalogViewModel = viewModel()
) {
    val darkTheme = isSystemInDarkTheme()

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

@Composable
private fun AppWindow(
    window: Window,
    darkTheme: Boolean
) {
    val view = LocalView.current
    window.statusBarColor = MaterialTheme.colors.background.toArgb()
    val controller = WindowInsetsControllerCompat(window, view)
    controller.isAppearanceLightNavigationBars = !darkTheme
    controller.isAppearanceLightStatusBars = !darkTheme
}

@OptIn(ExperimentalKatalogExtApi::class)
@Composable
private fun MainContent(viewModel: KatalogViewModel) {
    val errorMessage by viewModel.errorMessage.collectAsState()
    errorMessage?.let {
        ErrorMessage(text = it)
        return
    }

    val katalog by viewModel.katalog.collectAsState()
    val katalogValue = katalog ?: return
    val navController = viewModel.navController

    BackHandler(!navController.isTop) {
        navController.back()
    }

    ExtRootWrappers(
        rootWrappers = katalogValue.extensions.rootWrappers,
        extensions = katalogValue.extensions
    ) {
        MainPage(
            katalog = katalogValue,
            navController = navController,
            onClickItem = viewModel::handleClick
        )
    }
}

@ExperimentalKatalogExtApi
@Composable
private fun ExtRootWrappers(
    rootWrappers: List<ExtRootWrapper>,
    extensions: Extensions,
    content: @Composable () -> Unit
) {
    if (rootWrappers.isEmpty()) {
        content()
        return
    }
    ExtRootWrappers(
        rootWrappers = rootWrappers.dropLast(1),
        extensions = extensions
    ) {
        val target = rootWrappers.last()
        extensions.wrapperScope.target {
            content()
        }
    }
}
