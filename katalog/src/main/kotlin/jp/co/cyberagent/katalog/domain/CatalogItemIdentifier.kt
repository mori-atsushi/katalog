package jp.co.cyberagent.katalog.domain

internal class CatalogItemIdentifier(
    val parents: List<String>,
    val name: String
) {
    companion object {
        fun of(
            parent: CatalogItemIdentifier?,
            name: String
        ): CatalogItemIdentifier {
            return CatalogItemIdentifier(
                parents = parent?.let {
                    it.parents + it.name
                }.orEmpty(),
                name = name
            )
        }
    }

    val id: String = (parents + name).joinToString(
        separator = "/",
        prefix = "/"
    )

    override fun toString(): String {
        return id
    }

    override fun equals(other: Any?): Boolean {
        return other is CatalogItemIdentifier && other.id == this.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
