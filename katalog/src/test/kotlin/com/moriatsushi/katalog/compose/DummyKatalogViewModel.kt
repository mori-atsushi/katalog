package com.moriatsushi.katalog.compose

import com.moriatsushi.katalog.domain.KatalogContainer
import com.moriatsushi.katalog.dsl.GroupDefinition
import com.moriatsushi.katalog.ext.KatalogExt

internal fun dummyKatalogViewModel(
    title: String = "",
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition = {}
): KatalogViewModel {
    val container = KatalogContainer()
    container.register(
        title = title,
        extensions = extensions,
        groupDefinition = groupDefinition
    )
    return KatalogViewModel(container)
}
