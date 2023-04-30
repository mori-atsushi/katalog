package jp.co.cyberagent.katalog.ext.androidtheme

import androidx.annotation.StyleRes
import jp.co.cyberagent.katalog.ext.KatalogExt

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "AndroidThemeExt(themeResId)",
        "com.moriatsushi.katalog.ext.androidtheme.AndroidThemeExt",
    ),
)
@Suppress("FunctionName")
public fun AndroidThemeExt(
    @StyleRes themeResId: Int,
): KatalogExt {
    return com.moriatsushi.katalog.ext.androidtheme.AndroidThemeExt(themeResId)
}
