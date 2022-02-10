package jp.co.cyberagent.katalog.domain

import androidx.compose.runtime.Stable

@Stable
internal interface KatalogContainer {
    fun create(): Katalog
}
