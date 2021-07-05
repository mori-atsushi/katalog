package jp.co.cyberagent.katalog.ext.theme

import jp.co.cyberagent.katalog.ext.KatalogExt

internal fun createThemeExt(
    theme: ThemeDefinition
): KatalogExt {
    val builder = KatalogExt.Builder("Theme")
    builder.setComponentWrapper {
        theme { it() }
    }
    return builder.build()
}
