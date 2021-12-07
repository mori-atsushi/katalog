package jp.co.cyberagent.katalog.domain

internal class CatalogItemIdentifier(
    val parents: List<String>,
    val name: String,
    val count: Int
) {
    companion object {
        fun of(
            parent: CatalogItemIdentifier?,
            name: String,
            count: Int
        ): CatalogItemIdentifier {
            return CatalogItemIdentifier(
                parents = parent?.let {
                    it.parents + it.name
                }.orEmpty(),
                name = name,
                count = count
            )
        }
    }

    val id: String = buildString {
        (parents + name).forEach {
            append("/")
            append(it)
        }
        if (count > 0) {
            append("(")
            append(count + 1)
            append(")")
        }
    }

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
