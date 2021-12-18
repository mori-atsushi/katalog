package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.ExtWrapperScope
import jp.co.cyberagent.katalog.ext.ExtNavState

@OptIn(ExperimentalKatalogExtApi::class)
internal class ExtWrapperScopeImpl(
    override val navState: ExtNavState
) : ExtWrapperScope
