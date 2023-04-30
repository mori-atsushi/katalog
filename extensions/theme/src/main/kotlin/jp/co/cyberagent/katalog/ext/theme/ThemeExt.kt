package jp.co.cyberagent.katalog.ext.theme

import jp.co.cyberagent.katalog.ext.KatalogExt

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "ThemeExt(theme)",
        "com.moriatsushi.katalog.ext.theme.ThemeExt",
    ),
)
@Suppress("FunctionName")
public fun ThemeExt(theme: ThemeDefinition): KatalogExt {
    return com.moriatsushi.katalog.ext.theme.ThemeExt(theme)
}
