package com.moriatsushi.katalog

import com.moriatsushi.katalog.domain.KatalogContainer
import com.moriatsushi.katalog.dsl.Group
import com.moriatsushi.katalog.dsl.GroupDefinition
import com.moriatsushi.katalog.ext.KatalogExt

private const val DEFAULT_TITLE = "Katalog"

public fun registerKatalog(
    title: String = DEFAULT_TITLE,
    extensions: List<KatalogExt> = emptyList(),
    groupDefinition: GroupDefinition,
) {
    KatalogContainer.instance.register(title, extensions, groupDefinition)
}

public fun group(name: String, definition: GroupDefinition): Group {
    return Group(name, definition)
}
