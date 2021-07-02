package jp.co.cyberagent.katalog.domain

import jp.co.cyberagent.katalog.dsl.KatalogDefinition
import jp.co.cyberagent.katalog.ext.KatalogExt

internal data class Katalog(
    val title: String,
    val items: List<CatalogItem>,
    val extensions: List<KatalogExt>
) {
    companion object {
        private var definition: KatalogDefinition? = null

        fun register(definition: KatalogDefinition) {
            this.definition = definition
        }

        fun create(): Katalog {
            val definition = definition ?: throw IllegalStateException("require call register")
            return Mapper.dslToModel(definition)
        }
    }
}
