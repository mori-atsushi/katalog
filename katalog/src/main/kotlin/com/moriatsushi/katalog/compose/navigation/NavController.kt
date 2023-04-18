package com.moriatsushi.katalog.compose.navigation

import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf

@Stable
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

    fun push(destination: T) {
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
}
