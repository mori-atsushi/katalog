package com.moriatsushi.katalog.domain

import com.moriatsushi.katalog.dsl.GroupDefinition
import com.moriatsushi.katalog.ext.KatalogExt

internal fun dummyKatalog(
    title: String = "",
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition = {}
): Katalog {
    val container = KatalogContainer()
    container.register(
        title = title,
        extensions = extensions,
        groupDefinition = groupDefinition
    )
    return container.create()
}
