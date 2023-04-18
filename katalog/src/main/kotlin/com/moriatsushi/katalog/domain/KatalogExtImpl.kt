package com.moriatsushi.katalog.domain

import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtComponentWrapper
import com.moriatsushi.katalog.ext.ExtRootWrapper
import com.moriatsushi.katalog.ext.KatalogExt

@ExperimentalKatalogExtApi
internal class KatalogExtImpl(
    override val name: String,
    override val componentWrapper: ExtComponentWrapper?,
    override val rootWrapper: ExtRootWrapper?
) : KatalogExt
