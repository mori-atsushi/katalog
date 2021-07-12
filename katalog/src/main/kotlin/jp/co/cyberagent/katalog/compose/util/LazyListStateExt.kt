package jp.co.cyberagent.katalog.compose.util

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

@Composable
internal fun LazyListState.rememberIsTop(): State<Boolean> {
    return remember {
        derivedStateOf {
            this.firstVisibleItemIndex == 0 &&
                this.firstVisibleItemScrollOffset == 0
        }
    }
}
