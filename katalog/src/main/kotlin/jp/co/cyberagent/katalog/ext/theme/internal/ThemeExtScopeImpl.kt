package jp.co.cyberagent.katalog.ext.theme.internal

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.ext.theme.ThemeExtScope

internal class ThemeExtScopeImpl(
    override val content: @Composable () -> Unit
) : ThemeExtScope
