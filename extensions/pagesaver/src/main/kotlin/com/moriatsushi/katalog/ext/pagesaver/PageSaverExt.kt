package com.moriatsushi.katalog.ext.pagesaver

import com.moriatsushi.katalog.ext.KatalogExt
import com.moriatsushi.katalog.ext.pagesaver.internal.createPageSaverExt

@Suppress("FunctionName")
public fun PageSaverExt(): KatalogExt {
    return createPageSaverExt()
}
