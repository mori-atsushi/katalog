package com.moriatsushi.katalog.androidview.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

@Composable
internal fun rememberLifecycleOwner(): LifecycleOwner {
    val hostLifecycleOwner = LocalLifecycleOwner.current
    val lifecycleOwner = remember(hostLifecycleOwner) {
        ComposeLifecycleOwner(hostLifecycleOwner)
    }
    DisposableEffect(lifecycleOwner) {
        lifecycleOwner.onEnter()
        onDispose {
            lifecycleOwner.onDispose()
        }
    }
    return lifecycleOwner
}

private class ComposeLifecycleOwner(
    private val hostLifecycleOwner: LifecycleOwner
) : LifecycleOwner {
    private val registry = LifecycleRegistry(this)
    private var maxLifecycleState = Lifecycle.State.INITIALIZED

    init {
        hostLifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                updateState()
            }
        })
    }

    override fun getLifecycle(): Lifecycle {
        return registry
    }

    private fun updateState() {
        val hostLifecycleState = hostLifecycleOwner.lifecycle.currentState
        if (hostLifecycleState.ordinal < maxLifecycleState.ordinal) {
            registry.currentState = hostLifecycleState
        } else {
            registry.currentState = maxLifecycleState
        }
    }

    fun onEnter() {
        maxLifecycleState = Lifecycle.State.RESUMED
        updateState()
    }

    fun onDispose() {
        maxLifecycleState = Lifecycle.State.DESTROYED
        updateState()
    }
}
