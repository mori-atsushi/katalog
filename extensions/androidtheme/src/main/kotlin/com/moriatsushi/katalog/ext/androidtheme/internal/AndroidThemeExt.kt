package com.moriatsushi.katalog.ext.androidtheme.internal

import androidx.annotation.StyleRes
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.KatalogExt

@OptIn(ExperimentalKatalogExtApi::class)
internal fun createAndroidThemeExt(
    @StyleRes themeResId: Int,
): KatalogExt {
    val builder = KatalogExt.Builder("AndroidTheme")
    builder.setRootWrapper { content ->
        ContextTheme(
            themeResId = themeResId,
            content = content,
        )
    }
    builder.setComponentWrapper { content ->
        Background {
            content()
        }
    }
    return builder.build()
}
