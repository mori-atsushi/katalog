package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

internal class NavController<T>(startDestination: T) {
    private val _current = mutableStateOf(
        NavState.of(startDestination, 0)
    )
    private val _backStack = mutableStateListOf(_current.value)
    val current: State<NavState<T>> = _current

    val isTop: State<Boolean> = derivedStateOf {
        _backStack.size <= 1
    }

    fun push(destination: T) {
        val state = NavState.of(destination, _backStack.size)
        _backStack.add(state)
        _current.value = state
    }

    fun back(): Boolean {
        if (isTop.value) return false

        _backStack.removeLast()
        _current.value = _backStack.last()
        return true
    }

    fun hasState(state: NavState<T>): Boolean {
        return state.index <= _backStack.lastIndex
    }
}
