package jp.co.cyberagent.katalog.ext.android_theme

import androidx.annotation.StyleRes
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class AndroidThemeExt(
    @StyleRes private val themeResId: Int
) : KatalogExt {
    override val name: String = "Android Theme"
}
