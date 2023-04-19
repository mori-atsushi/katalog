package com.moriatsushi.katalog.compose.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import com.moriatsushi.katalog.compose.widget.ClickMask

@Composable
internal fun <T : NavDestination> NavRoot(
    navController: NavController<T>,
    transitionSpec: AnimatedContentTransitionScope<NavState<T>>.() -> ContentTransform =
        NavAnimation.createSlideSpec(),
    component: @Composable (NavState<T>) -> Unit
) {
    val saveableStateHolder = rememberSaveableStateHolder()

    AnimatedPage(
        targetState = navController.current,
        transitionSpec = transitionSpec
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
private fun <T : NavDestination> NavChild(
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

@Composable
private fun <T> AnimatedPage(
    targetState: NavState<T>,
    transitionSpec: AnimatedContentTransitionScope<NavState<T>>.() -> ContentTransform,
    content: @Composable (state: NavState<T>) -> Unit
) {
    AnimatedContent(
        targetState = targetState,
        transitionSpec = transitionSpec
    ) {
        content(it)
        ClickMask(
            modifier = Modifier.fillMaxSize(),
            enabled = it != targetState
        )
    }
}
