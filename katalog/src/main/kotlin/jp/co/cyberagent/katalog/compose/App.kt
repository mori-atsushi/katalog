package jp.co.cyberagent.katalog.compose

import android.view.Window
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.co.cyberagent.katalog.compose.navigation.rememberExtNavState
import jp.co.cyberagent.katalog.compose.page.MainPage
import jp.co.cyberagent.katalog.compose.res.materialColors
import jp.co.cyberagent.katalog.compose.widget.ErrorMessage
import jp.co.cyberagent.katalog.domain.ExtWrapperScopeImpl
import jp.co.cyberagent.katalog.domain.DefaultKatalogContainer
import jp.co.cyberagent.katalog.domain.KatalogContainer
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState
import jp.co.cyberagent.katalog.ext.ExtRootWrapper

@Composable
internal fun App(
    window: Window,
    container: KatalogContainer = DefaultKatalogContainer.instance
) {
    val viewModelFactory = KatalogViewModel.Factory(container)
    val viewModel: KatalogViewModel = viewModel(factory = viewModelFactory)
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

    val onBackPressedDispatcherOwner = LocalOnBackPressedDispatcherOwner.current
    val navController = viewModel.navController
    val extNavState = rememberExtNavState(
        navController = navController,
        katalog = katalogValue
    )

    BackHandler(!navController.isTop) {
        navController.back()
    }

    ExtRootWrappers(
        extNavState = extNavState,
        rootWrappers = katalogValue.extensions.rootWrappers
    ) {
        MainPage(
            katalog = katalogValue,
            navController = navController,
            extNavState = extNavState,
            onClickItem = viewModel::handleClick,
            onClickBack = {
                onBackPressedDispatcherOwner?.onBackPressedDispatcher?.onBackPressed()
            }
        )
    }
}

@ExperimentalKatalogExtApi
@Composable
private fun ExtRootWrappers(
    extNavState: ExtNavState,
    rootWrappers: List<ExtRootWrapper>,
    content: @Composable () -> Unit
) {
    if (rootWrappers.isEmpty()) {
        content()
        return
    }
    ExtRootWrappers(
        extNavState = extNavState,
        rootWrappers = rootWrappers.dropLast(1)
    ) {
        val target = rootWrappers.last()
        val scope = ExtWrapperScopeImpl(
            navState = extNavState
        )
        scope.target {
            content()
        }
    }
}
