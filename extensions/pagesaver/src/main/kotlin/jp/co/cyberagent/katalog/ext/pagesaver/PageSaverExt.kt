package jp.co.cyberagent.katalog.ext.pagesaver

import androidx.annotation.VisibleForTesting
import jp.co.cyberagent.katalog.ext.KatalogExt
import jp.co.cyberagent.katalog.ext.pagesaver.internal.PageStore
import jp.co.cyberagent.katalog.ext.pagesaver.internal.createPageSaverExt

@Suppress("FunctionName")
public fun PageSaverExt(): KatalogExt {
    return createPageSaverExt()
}

@VisibleForTesting
@Suppress("FunctionName")
internal fun PageSaverExt(
    pageStore: PageStore
): KatalogExt {
    return createPageSaverExt(pageStore)
}
