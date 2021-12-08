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

        fun ofOrNull(id: String): CatalogItemIdentifier? {
            if (!id.startsWith("/")) return null
            val values = id.split("/").filterNot { it.isEmpty() }
            if (values.isEmpty()) return null
            val parents = values.dropLast(1).map { decode(it) }
            val last = values.last()
            val numRegex = Regex("""\((\d)\)$""")
            val name = decode(numRegex.replace(last, ""))
            val num = numRegex.find(last)?.value
                ?.getOrNull(1)
                ?.digitToIntOrNull()
            val count = num?.let { it - 1 } ?: 0
            return CatalogItemIdentifier(
                parents = parents,
                name = name,
                count = count
            )
        }

        private val encodeList = listOf(
            "%" to "%25",
            "(" to "%28",
            ")" to "%29",
            "/" to "%2F"
        )

        private fun encode(value: String): String {
            return encodeList.fold(value) { aac, it ->
                aac.replace(it.first, it.second)
            }
        }

        private fun decode(value: String): String {
            return encodeList.reversed().fold(value) { aac, it ->
                aac.replace(it.second, it.first)
            }
        }
    }

    val id: String = buildString {
        (parents + name).forEach {
            append("/")
            append(encode(it))
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
        return other is CatalogItemIdentifier && equals(other, false)
    }

    fun equals(
        other: CatalogItemIdentifier,
        ignoreCount: Boolean = false
    ): Boolean {
        return if (ignoreCount) {
            other.name == name && other.parents == parents
        } else {
            other.id == this.id
        }
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
