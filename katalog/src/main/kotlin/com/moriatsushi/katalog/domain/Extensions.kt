package com.moriatsushi.katalog.domain

import androidx.compose.runtime.Stable
import com.moriatsushi.katalog.ext.ExperimentalKatalogExtApi
import com.moriatsushi.katalog.ext.ExtComponentWrapper
import com.moriatsushi.katalog.ext.ExtRootWrapper
import com.moriatsushi.katalog.ext.KatalogExt

@OptIn(ExperimentalKatalogExtApi::class)
@Stable
internal data class Extensions(
    val list: List<KatalogExt>
) {
    val rootWrappers: List<ExtRootWrapper> =
        list.mapNotNull { it.rootWrapper }

    val componentWrappers: List<ExtComponentWrapper> =
        list.mapNotNull { it.componentWrapper }
}
