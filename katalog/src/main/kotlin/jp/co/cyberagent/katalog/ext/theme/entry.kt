package jp.co.cyberagent.katalog.ext.theme

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.dsl.ExtensionScope
import jp.co.cyberagent.katalog.ext.theme.internal.createThemeExt

fun ExtensionScope.theme(theme: @Composable ThemeExtScope.() -> Unit) {
    add(createThemeExt(theme))
}
