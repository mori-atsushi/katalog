package jp.co.cyberagent.katalog.ext.pagesaver.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalKatalogExtApi
@Composable
internal fun PageSaver(
    title: String,
    navState: ExtNavState,
    pageStore: PageStore,
    content: @Composable () -> Unit
) {
    val state = rememberPageSagerState(
        title = title,
        navState = navState,
        pageStore = pageStore
    )

    if (state.isInitialized) {
        content()
    }
}

@Immutable
private data class PageSagerState(
    val isInitialized: Boolean
)

@ExperimentalKatalogExtApi
@Composable
private fun rememberPageSagerState(
    title: String,
    navState: ExtNavState,
    pageStore: PageStore = rememberPageStore()
): PageSagerState {
    var isInitialized by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val backStack = pageStore.read(title)
        if (backStack != null && navState.backStack != backStack) {
            navState.restore(backStack)
        }

        snapshotFlow { navState.backStack }
            .onEach { pageStore.update(title, navState.backStack) }
            .launchIn(this)

        isInitialized = true
    }

    return PageSagerState(isInitialized)
}
