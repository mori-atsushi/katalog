package com.moriatsushi.katalog.domain

import com.moriatsushi.katalog.dsl.GroupDefinition
import com.moriatsushi.katalog.ext.KatalogExt

internal data class KatalogDefinition(
    val title: String,
    val extensions: List<KatalogExt>,
    val groupDefinition: GroupDefinition
) {
    fun build(): Katalog {
        val groupScope = GroupScopeImpl()
        groupScope.groupDefinition()
        return Katalog(
            title = title,
            items = groupScope.items,
            extensions = Extensions(extensions)
        )
    }
}
