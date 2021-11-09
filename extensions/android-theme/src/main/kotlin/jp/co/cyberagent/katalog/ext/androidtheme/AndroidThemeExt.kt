package jp.co.cyberagent.katalog.ext.androidtheme

import androidx.annotation.StyleRes
import jp.co.cyberagent.katalog.ext.KatalogExt
import jp.co.cyberagent.katalog.ext.androidtheme.internal.createAndroidThemeExt

@Suppress("FunctionName")
public fun AndroidThemeExt(
    @StyleRes themeResId: Int
): KatalogExt {
    return createAndroidThemeExt(themeResId)
}
