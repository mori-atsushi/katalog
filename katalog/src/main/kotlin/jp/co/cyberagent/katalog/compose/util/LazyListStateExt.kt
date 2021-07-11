package jp.co.cyberagent.katalog.compose.util

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
internal fun LazyListState.rememberIsTop(): Boolean {
    return remember(
        this.firstVisibleItemIndex,
        this.firstVisibleItemScrollOffset
    ) {
        this.firstVisibleItemIndex == 0 &&
            this.firstVisibleItemScrollOffset == 0
    }
}
