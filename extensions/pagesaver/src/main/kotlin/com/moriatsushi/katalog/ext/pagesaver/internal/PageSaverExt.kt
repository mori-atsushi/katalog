package com.moriatsushi.katalog.ext.pagesaver.internal

import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.KatalogExt

@OptIn(ExperimentalKatalogExtApi::class)
internal fun createPageSaverExt(): KatalogExt {
    val builder = KatalogExt.Builder("PageSaver")
    builder.setRootWrapper { content ->
        PageSaver(
            navState = navState,
            content = content
        )
    }
    return builder.build()
}
