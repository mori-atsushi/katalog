package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.CatalogDefinition

internal data class Catalog(
    val title: String,
    val items: List<CatalogItem>
) {
    companion object {
        private var definition: CatalogDefinition? = null

        fun register(definition: CatalogDefinition) {
            this.definition = definition
        }

        fun create(): Catalog {
            val definition = definition ?: throw IllegalStateException("require call register")
            return Mapper.dslToModel(definition)
        }
    }
}
