package jp.co.cyberagent.katalog.compose.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun <T : Any> ModalVisibility(
    value: T?,
    content: @Composable (T) -> Unit
) {
    val offset: (fullSize: IntSize) -> IntOffset = {
        IntOffset(0, it.height / 3)
    }
    AnimatedVisibility(
        visible = value != null,
        enter = fadeIn() + slideIn(initialOffset = offset),
        exit = fadeOut() + slideOut(targetOffset = offset)
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
