package jp.co.cyberagent.katalog.compose.util

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner

@Composable
internal fun BackPressedEffect(
    key: Any,
    onBackPressed: () -> Boolean
) {
    val backDispatcherOwner = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "require LocalOnBackPressedDispatcherOwner.current"
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key, backDispatcherOwner, lifecycleOwner) {
        val backPressedDispatcher = backDispatcherOwner.onBackPressedDispatcher
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val backed = onBackPressed()
                if (!backed) {
                    isEnabled = false
                    backPressedDispatcher.onBackPressed()
                    isEnabled = true
                }
            }
        }
        backPressedDispatcher.addCallback(lifecycleOwner, callback)
        onDispose {
            callback.remove()
        }
    }
}
