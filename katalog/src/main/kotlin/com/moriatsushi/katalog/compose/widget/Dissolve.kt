package com.moriatsushi.katalog.compose.widget

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

private const val ANIMATION_DURATION = 300

@Composable
internal fun <T> Dissolve(
    targetState: T,
    modifier: Modifier = Modifier,
    content: @Composable (T) -> Unit
) {
    AnimatedContent(
        targetState = targetState,
        modifier = modifier,
        transitionSpec = {
            ContentTransform(
                targetContentEnter = fadeIn(
                    animationSpec = tween(ANIMATION_DURATION)
                ),
                initialContentExit = fadeOut(
                    animationSpec = snap(ANIMATION_DURATION)
                )
            )
        }
    ) {
        content(it)
    }
}
