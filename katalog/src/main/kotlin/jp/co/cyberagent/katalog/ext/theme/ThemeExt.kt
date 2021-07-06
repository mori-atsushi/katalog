package jp.co.cyberagent.katalog.ext.theme

import jp.co.cyberagent.katalog.ext.KatalogExt
import jp.co.cyberagent.katalog.ext.theme.internal.createThemeExt

@Suppress("FunctionName")
fun ThemeExt(theme: ThemeDefinition): KatalogExt {
    return createThemeExt(theme)
}
