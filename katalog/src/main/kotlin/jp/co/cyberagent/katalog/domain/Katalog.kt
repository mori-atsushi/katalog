package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.GroupDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

internal data class Katalog(
    val title: String,
    val items: List<CatalogItem>,
    val extensions: Extensions
) {
    companion object {
        private var definition: KatalogDefinition? = null

        fun register(
            title: String,
            extensions: List<KatalogExt>,
            groupDefinition: GroupDefinition
        ) {
            this.definition = KatalogDefinition(
                title = title,
                extensions = extensions,
                groupDefinition = groupDefinition
            )
        }

        fun create(): Katalog {
            val definition = definition ?: throw IllegalStateException("require call register")
            return definition.build()
        }
    }
}
