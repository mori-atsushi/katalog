package jp.co.cyberagent.katalog.ext.pagesaver.internal

import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.KatalogExt

@OptIn(ExperimentalKatalogExtApi::class)
internal fun createPageSaverExt(
    pageStore: PageStore? = null
): KatalogExt {
    val builder = KatalogExt.Builder("PageSaver")
    builder.setRootWrapper { content ->
        PageSaver(
            navState = navState,
            pageStore = pageStore ?: rememberPageStore(),
            content = content
        )
    }
    return builder.build()
}
