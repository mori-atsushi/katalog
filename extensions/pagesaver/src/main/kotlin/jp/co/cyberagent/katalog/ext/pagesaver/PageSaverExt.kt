package jp.co.cyberagent.katalog.ext.pagesaver

import jp.co.cyberagent.katalog.ext.KatalogExt

@Deprecated(
    "The package name has changed.",
    ReplaceWith(
        "PageSaverExt()",
        "com.moriatsushi.katalog.ext.pagesaver.PageSaverExt",
    ),
)
@Suppress("FunctionName")
public fun PageSaverExt(): KatalogExt {
    return com.moriatsushi.katalog.ext.pagesaver.PageSaverExt()
}
