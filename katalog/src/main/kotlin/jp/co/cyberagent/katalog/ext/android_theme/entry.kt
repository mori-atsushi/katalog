package jp.co.cyberagent.katalog.ext.android_theme

import androidx.annotation.StyleRes
import jp.co.cyberagent.katalog.dsl.ExtensionScope
import jp.co.cyberagent.katalog.ext.android_theme.internal.createAndroidThemeExt

fun ExtensionScope.setThemeResId(@StyleRes resId: Int) {
    add(createAndroidThemeExt(resId))
}
