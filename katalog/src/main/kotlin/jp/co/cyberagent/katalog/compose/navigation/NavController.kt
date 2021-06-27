package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

internal class NavController<T>(startDestination: T) {
    private val _current = mutableStateOf(
        NavState.of(startDestination, 0)
    )
    private val _backStack = mutableListOf(_current.value)
    val current: State<NavState<T>> = _current

    fun push(destination: T) {
        val state = NavState.of(destination, _backStack.size)
        _backStack.add(state)
        _current.value = state
    }

    fun back(): Boolean {
        if (_backStack.size <= 1) return false

        _backStack.removeLast()
        _current.value = _backStack.last()
        return true
    }

    fun hasState(state: NavState<T>): Boolean {
        return state.index <= _backStack.lastIndex
    }
}
