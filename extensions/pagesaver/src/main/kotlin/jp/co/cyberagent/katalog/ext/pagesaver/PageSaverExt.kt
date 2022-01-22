package jp.co.cyberagent.katalog.ext.pagesaver

import jp.co.cyberagent.katalog.ext.KatalogExt
import jp.co.cyberagent.katalog.ext.pagesaver.internal.createPageSaverExt

@Suppress("FunctionName")
public fun PageSaverExt(): KatalogExt {
    return createPageSaverExt()
}
