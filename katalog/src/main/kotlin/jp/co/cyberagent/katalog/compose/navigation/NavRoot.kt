package jp.co.cyberagent.katalog.compose.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.runtime.saveable.rememberSaveableStateHolder

@ExperimentalAnimationApi
@Composable
internal fun <T : NavDestination> NavRoot(
    navController: NavController<T>,
    transitionSpec: AnimatedContentScope<NavState<T>>.() -> ContentTransform = NavAnimation.createSlideSpec(),
    component: @Composable (NavState<T>) -> Unit
) {
    val current by navController.current
    val saveableStateHolder = rememberSaveableStateHolder()

    BackHandler {
        navController.back()
    }

    AnimatedPage(
        targetState = current,
        transitionSpec = transitionSpec,
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

@ExperimentalAnimationApi
@Composable
private fun <T> AnimatedPage(
    targetState: NavState<T>,
    transitionSpec: AnimatedContentScope<NavState<T>>.() -> ContentTransform,
    onComplete: () -> Unit = {},
    content: @Composable (state: NavState<T>) -> Unit
) {
    AnimatedContent(
        targetState = targetState,
        transitionSpec = transitionSpec
    ) {
        LaunchedEffect(transition.currentState) {
            if (transition.currentState == transition.targetState) {
                onComplete()
            }
        }
        content(it)
    }
}
