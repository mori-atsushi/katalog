package jp.co.cyberagent.katalog.ext.android_theme

import androidx.annotation.StyleRes
import jp.co.cyberagent.katalog.dsl.KatalogScope

fun KatalogScope.setThemeResId(@StyleRes resId: Int) {
    addExtension()
}
