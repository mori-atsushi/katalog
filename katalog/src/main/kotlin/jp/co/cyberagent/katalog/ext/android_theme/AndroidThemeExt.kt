package jp.co.cyberagent.katalog.ext.android_theme

import androidx.annotation.StyleRes
import jp.co.cyberagent.katalog.ext.KatalogExt
import jp.co.cyberagent.katalog.ext.android_theme.internal.createAndroidThemeExt

@Suppress("FunctionName")
fun AndroidThemeExt(
    @StyleRes themeResId: Int
): KatalogExt {
    return createAndroidThemeExt(themeResId)
}
