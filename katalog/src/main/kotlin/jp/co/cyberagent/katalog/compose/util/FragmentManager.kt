package jp.co.cyberagent.katalog.compose.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.fragment.app.FragmentManager

internal val LocalFragmentManager = staticCompositionLocalOf<FragmentManager> {
    error("require provide LocalFragmentManager")
}

@Composable
internal fun FragmentManagerProvider(
    fragmentManager: FragmentManager,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalFragmentManager provides fragmentManager,
        content = content
    )
}
