package jp.co.cyberagent.katalog.ext.androidtheme.internal

import android.content.ContextWrapper
import androidx.annotation.StyleRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
internal fun ContextTheme(
    @StyleRes themeResId: Int,
    content: @Composable () -> Unit
) {
    val originalContext = LocalContext.current
    val themedContext = remember(originalContext) {
        ContextWrapper(originalContext).apply {
            setTheme(themeResId)
        }
    }
    CompositionLocalProvider(
        LocalContext provides themedContext,
        content = content
    )
}
