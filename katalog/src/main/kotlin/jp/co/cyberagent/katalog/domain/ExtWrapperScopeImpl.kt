package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtNavState
import jp.co.cyberagent.katalog.ext.ExtWrapperScope

@OptIn(ExperimentalKatalogExtApi::class)
internal class ExtWrapperScopeImpl(
    override val title: String,
    override val navState: ExtNavState
) : ExtWrapperScope
