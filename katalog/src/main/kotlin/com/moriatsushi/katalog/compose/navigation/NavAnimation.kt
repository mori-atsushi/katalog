package com.moriatsushi.katalog.compose.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.unit.IntOffset

internal object NavAnimation {
    private val slideAnimationSpec = spring(
        stiffness = Spring.StiffnessMedium,
        visibilityThreshold = IntOffset.VisibilityThreshold,
    )

    fun <T> createSlideSpec(): AnimatedContentTransitionScope<NavState<T>>.() -> ContentTransform =
        {
            if (targetState.index > initialState.index) {
                ContentTransform(
                    targetContentEnter = slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = slideAnimationSpec,
                    ),
                    initialContentExit = slideOutHorizontally(
                        targetOffsetX = { -it / 5 },
                        animationSpec = slideAnimationSpec,
                    ),
                    targetContentZIndex = targetState.index.toFloat(),
                )
            } else {
                ContentTransform(
                    targetContentEnter = slideInHorizontally(
                        initialOffsetX = { -it / 5 },
                        animationSpec = slideAnimationSpec,
                    ),
                    initialContentExit = slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = slideAnimationSpec,
                    ),
                    targetContentZIndex = targetState.index.toFloat(),
                )
            }
        }

    private const val upExpandingMills = 200
    private const val upCollapsingMills = 150

    fun <T> createUpSpec(): AnimatedContentTransitionScope<NavState<T>>.() -> ContentTransform =
        {
            if (targetState.index > initialState.index) {
                ContentTransform(
                    targetContentEnter = slideInVertically(
                        initialOffsetY = { it / 3 },
                        animationSpec = tween(upExpandingMills, easing = LinearOutSlowInEasing),
                    ) + fadeIn(
                        animationSpec = tween(upExpandingMills, easing = LinearOutSlowInEasing),
                    ),
                    initialContentExit = fadeOut(
                        animationSpec = snap(delayMillis = upExpandingMills),
                    ),
                    targetContentZIndex = targetState.index.toFloat(),
                )
            } else {
                ContentTransform(
                    targetContentEnter = EnterTransition.None,
                    initialContentExit = slideOutVertically(
                        targetOffsetY = { it / 3 },
                        animationSpec = tween(upCollapsingMills, easing = FastOutLinearInEasing),
                    ) + fadeOut(
                        animationSpec = tween(upCollapsingMills, easing = FastOutLinearInEasing),
                    ),
                    targetContentZIndex = targetState.index.toFloat(),
                )
            }
        }
}
