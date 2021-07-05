package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.ext.ExtComponentWrapper
import jp.co.cyberagent.katalog.ext.ExtRootWrapper
import jp.co.cyberagent.katalog.ext.KatalogExt

internal class KatalogExtImpl(
    override val name: String,
    override val componentWrapper: ExtComponentWrapper?,
    override val rootWrapper: ExtRootWrapper?
) : KatalogExt
