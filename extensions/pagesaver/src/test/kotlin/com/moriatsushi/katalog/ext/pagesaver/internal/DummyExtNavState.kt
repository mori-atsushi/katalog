package com.moriatsushi.katalog.ext.pagesaver.internal

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtNavState

@ExperimentalKatalogExtApi
internal class DummyExtNavState : ExtNavState {
    override val current: String by derivedStateOf {
        backStack.last()
    }
    private val _backStack = mutableStateListOf("/")
    override val backStack: List<String> by derivedStateOf {
        _backStack.toList()
    }

    override fun navigateTo(destination: String): Boolean {
        _backStack.add(destination)
        return true
    }

    override fun restore(backStack: List<String>): Boolean {
        _backStack.clear()
        _backStack.addAll(backStack)
        return true
    }
}
