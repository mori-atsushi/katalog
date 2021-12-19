package jp.co.cyberagent.katalog.ext.pagesaver.internal

import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.KatalogExt

@OptIn(ExperimentalKatalogExtApi::class)
internal fun createPageSaverExt(): KatalogExt {
    val builder = KatalogExt.Builder("PageSaver")
    builder.setRootWrapper { content ->
        PageSaver(navState)
        content()
    }
    return builder.build()
}
