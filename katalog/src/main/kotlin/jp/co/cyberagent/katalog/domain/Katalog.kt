package jp.co.cyberagent.katalog.domain

internal data class Katalog(
    val title: String,
    val items: List<CatalogItem>,
    val extensions: Extensions
)
