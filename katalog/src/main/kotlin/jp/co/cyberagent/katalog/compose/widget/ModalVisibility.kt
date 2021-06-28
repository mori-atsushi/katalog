package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun <T : Any> ModalVisibility(
    value: T?,
    content: @Composable (T) -> Unit
) {
    AnimatedVisibility(
        visible = value != null,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        var cache by remember {
            mutableStateOf(value)
        }
        value?.let {
            cache = it
        }
        cache?.let {
            content(it)
        }
    }
}
