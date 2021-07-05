package jp.co.cyberagent.katalog.ext.android_theme

import androidx.annotation.StyleRes
import jp.co.cyberagent.katalog.ext.KatalogExt

internal fun createAndroidThemeExt(
    @StyleRes themeResId: Int
): KatalogExt {
    val builder = KatalogExt.Builder("AndroidTheme")
    builder.setRootWrapper {
        val themeSelected = rememberThemeSelected(themeResId)
        if (themeSelected) {
            content()
        }
    }
    return builder.build()
}
