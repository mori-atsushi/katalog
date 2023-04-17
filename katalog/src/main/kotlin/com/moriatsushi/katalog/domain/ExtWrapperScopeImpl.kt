package com.moriatsushi.katalog.domain

import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtNavState
import com.moriatsushi.katalog.ext.ExtWrapperScope

@OptIn(ExperimentalKatalogExtApi::class)
internal class ExtWrapperScopeImpl(
    override val navState: ExtNavState
) : ExtWrapperScope
