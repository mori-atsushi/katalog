package com.moriatsushi.katalog.ext.androidtheme

import androidx.annotation.StyleRes
import com.moriatsushi.katalog.ext.KatalogExt
import com.moriatsushi.katalog.ext.androidtheme.internal.createAndroidThemeExt

@Suppress("FunctionName")
public fun AndroidThemeExt(
    @StyleRes themeResId: Int
): KatalogExt {
    return createAndroidThemeExt(themeResId)
}
