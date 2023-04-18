package com.moriatsushi.katalog.ext.theme

import com.moriatsushi.katalog.ext.KatalogExt
import com.moriatsushi.katalog.ext.theme.internal.createThemeExt

@Suppress("FunctionName")
public fun ThemeExt(theme: ThemeDefinition): KatalogExt {
    return createThemeExt(theme)
}
