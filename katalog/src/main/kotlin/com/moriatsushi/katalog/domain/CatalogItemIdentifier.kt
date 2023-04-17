package com.moriatsushi.katalog.domain

import androidx.compose.runtime.Immutable

@Immutable
internal class CatalogItemIdentifier(
    val parents: List<CatalogItemIdentifier>,
    val name: String,
    val count: Int
) {
    companion object {
        const val rootId = "/"

        fun of(
            parent: CatalogItemIdentifier?,
            name: String,
            count: Int
        ): CatalogItemIdentifier {
            return CatalogItemIdentifier(
                parents = parent?.let {
                    it.parents + it
                }.orEmpty(),
                name = name,
                count = count
            )
        }

        fun ofOrNull(id: String): CatalogItemIdentifier? {
            if (!id.startsWith("/")) return null

            val values = id.removePrefix("/").split("/")
            if (values.isEmpty()) return null

            val numRegex = Regex("""\((\d)\)$""")
            val list = values.fold(emptyList<CatalogItemIdentifier>()) { acc, it ->
                val name = decode(numRegex.replace(it, ""))
                val num = numRegex.find(it)?.value
                    ?.getOrNull(1)
                    ?.digitToIntOrNull()
                val count = num?.let { it - 1 } ?: 0
                acc + CatalogItemIdentifier(
                    parents = acc,
                    name = name,
                    count = count
                )
            }
            return list.lastOrNull()
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

    val id: String = (parents + this).joinToString(separator = "") {
        buildString {
            append("/")
            append(encode(it.name))
            if (it.count > 0) {
                append("(")
                append(it.count + 1)
                append(")")
            }
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
