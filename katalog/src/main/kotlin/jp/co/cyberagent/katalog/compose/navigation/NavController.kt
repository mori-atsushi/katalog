package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf

internal class NavController<T : NavDestination>(
    startDestination: T
) {
    private val _backStack = mutableStateListOf(NavState.of(startDestination, 0))
    val backStack: List<NavState<T>> = _backStack

    val current: NavState<T> by derivedStateOf {
        _backStack.last()
    }

    val isTop: Boolean by derivedStateOf {
        if (_backStack.size > 1) return@derivedStateOf false
        val childNavController = current.destination.childNavController
        childNavController == null || childNavController.isTop
    }

    private var isTransitioning = false

    fun push(destination: T) {
        if (isTransitioning) return
        isTransitioning = true

        val state = NavState.of(destination, _backStack.size)
        _backStack.add(state)
    }

    fun restore(backStack: List<T>) {
        _backStack.clear()
        backStack.forEach {
            val state = NavState.of(it, _backStack.size)
            _backStack.add(state)
        }
    }

    fun back(): Boolean {
        if (isTop) return false

        val childNavController = current.destination.childNavController
        if (childNavController != null && childNavController.back()) {
            return true
        }

        _backStack.removeLast()
        return true
    }

    fun hasState(state: NavState<T>): Boolean {
        return _backStack.any {
            it.key == state.key
        }
    }

    fun handleCompleteTransition() {
        isTransitioning = false
    }
}
