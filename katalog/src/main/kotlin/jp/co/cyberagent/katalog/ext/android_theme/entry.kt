package jp.co.cyberagent.katalog.ext.android_theme

import androidx.annotation.StyleRes
import jp.co.cyberagent.katalog.dsl.ExtensionScope

fun ExtensionScope.setThemeResId(@StyleRes resId: Int) {
    add(createAndroidThemeExt(resId))
}
