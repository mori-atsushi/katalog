package jp.co.cyberagent.katalog.ext.theme

import androidx.compose.runtime.Composable
import jp.co.cyberagent.katalog.ext.KatalogExt
import jp.co.cyberagent.katalog.ext.theme.internal.createThemeExt

@Suppress("FunctionName")
fun ThemeExt(theme: @Composable ThemeExtScope.() -> Unit): KatalogExt {
    return createThemeExt(theme)
}
