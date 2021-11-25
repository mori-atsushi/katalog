package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.runtime.saveable.rememberSaveableStateHolder

@Composable
internal fun <T> NavRoot(
    navController: NavController<T>,
    component: @Composable (NavState<T>) -> Unit
) {
    val current by navController.current
    val saveableStateHolder = rememberSaveableStateHolder()

    AnimatedPage(current) {
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
    content: @Composable (state: NavState<T>) -> Unit
) {
    AnimatedContent(
        targetState = targetState,
        transitionSpec = {
            if (targetState.index > initialState.index) {
                ContentTransform(
                    targetContentEnter = slideInHorizontally(initialOffsetX = { it }),
                    initialContentExit = slideOutHorizontally(targetOffsetX = { -it / 5 }),
                    targetContentZIndex = targetState.index.toFloat()
                )
            } else {
                ContentTransform(
                    targetContentEnter = slideInHorizontally(initialOffsetX = { -it / 5 }),
                    initialContentExit = slideOutHorizontally(targetOffsetX = { it }),
                    targetContentZIndex = targetState.index.toFloat()
                )
            }
        }
    ) {
        content(it)
    }
}