package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.unit.IntOffset

@Composable
internal fun <T> NavRoot(
    navController: NavController<T>,
    component: @Composable (NavState<T>) -> Unit
) {
    val current by navController.current
    val saveableStateHolder = rememberSaveableStateHolder()

    AnimatedPage(
        targetState = current,
        onComplete = navController::handleCompleteTransition
    ) {
        NavChild(
            navController = navController,
            state = it,
            saveableStateHolder = saveableStateHolder,
            component = component
        )
    }
}

@Composable
private fun <T> NavChild(
    navController: NavController<T>,
    state: NavState<T>,
    saveableStateHolder: SaveableStateHolder,
    component: @Composable (NavState<T>) -> Unit
) {
    DisposableEffect(state) {
        onDispose {
            if (!navController.hasState(state)) {
                saveableStateHolder.removeState(state.key)
            }
        }
    }
    saveableStateHolder.SaveableStateProvider(state.key) {
        component(state)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun <T> AnimatedPage(
    targetState: NavState<T>,
    onComplete: () -> Unit = {},
    content: @Composable (state: NavState<T>) -> Unit
) {
    val animationSpec = spring(
        stiffness = Spring.StiffnessMedium,
        visibilityThreshold = IntOffset.VisibilityThreshold
    )
    AnimatedContent(
        targetState = targetState,
        transitionSpec = {
            if (targetState.index > initialState.index) {
                ContentTransform(
                    targetContentEnter = slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = animationSpec
                    ),
                    initialContentExit = slideOutHorizontally(
                        targetOffsetX = { -it / 5 },
                        animationSpec = animationSpec
                    ),
                    targetContentZIndex = targetState.index.toFloat()
                )
            } else {
                ContentTransform(
                    targetContentEnter = slideInHorizontally(
                        initialOffsetX = { -it / 5 },
                        animationSpec = animationSpec
                    ),
                    initialContentExit = slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = animationSpec
                    ),
                    targetContentZIndex = targetState.index.toFloat()
                )
            }
        }
    ) {
        LaunchedEffect(transition.currentState) {
            if (transition.currentState == transition.targetState) {
                onComplete()
            }
        }
        content(it)
    }
}
