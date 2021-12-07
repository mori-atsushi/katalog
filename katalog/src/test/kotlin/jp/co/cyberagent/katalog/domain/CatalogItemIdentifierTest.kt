package jp.co.cyberagent.katalog.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class CatalogItemIdentifierTest {
    @Test
    fun id() {
        val target = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 0
        )
        val actual = target.id
        val expected = "/Group1/Group2/Item"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun id_withCount() {
        val target = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 1
        )
        val actual = target.id
        val expected = "/Group1/Group2/Item(2)"
        assertThat(actual).isEqualTo(expected)
    }
}
