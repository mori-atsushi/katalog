package jp.co.cyberagent.katalog.ext.pagesaver.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalKatalogExtApi
@Composable
internal fun PageSaver(
    navState: ExtNavState,
    pageStore: PageStore = rememberPageStore()
) {
    LaunchedEffect(Unit) {
        val backStack = pageStore.read()
        if (backStack != null && navState.backStack != backStack) {
            navState.restore(backStack)
        }

        snapshotFlow { navState.backStack }
            .onEach { pageStore.update(navState.backStack) }
            .launchIn(this)
    }
}
