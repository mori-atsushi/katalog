package jp.co.cyberagent.katalog.compose.navigation

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner

@Composable
internal fun <T> rememberNavController(startDestination: T): NavController<T> {
    val navController = remember { NavController(startDestination) }
    BackPressedEffect(navController)
    return navController
}

@Composable
private fun <T> BackPressedEffect(
    navController: NavController<T>
) {
    val backDispatcherOwner = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "require LocalOnBackPressedDispatcherOwner.current"
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(backDispatcherOwner, lifecycleOwner) {
        val backPressedDispatcher = backDispatcherOwner.onBackPressedDispatcher
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val backed = navController.back()
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
