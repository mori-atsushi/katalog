package jp.co.cyberagent.katalog.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class CatalogItemIdentifierTest {
    @Test
    fun ofOrNull() {
        val target = "/Group1/Group2/Item"
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val expected = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 0
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_withCount() {
        val target = "/Group1/Group2/Item(2)"
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val expected = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 1
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_escapeSlash() {
        val target = "/Parent%2FItem"
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val expected = CatalogItemIdentifier(
            parents = listOf(),
            name = "Parent/Item",
            count = 0
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_escapeParentheses() {
        val target = "/Item%282%29"
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val expected = CatalogItemIdentifier(
            parents = listOf(),
            name = "Item(2)",
            count = 0
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_escapePercent() {
        val target = "/Parent%252FItem"
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val expected = CatalogItemIdentifier(
            parents = listOf(),
            name = "Parent%2FItem",
            count = 0
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_invalid() {
        val target = "invalid"
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val expected = null
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_empty() {
        val target = ""
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val expected = null
        assertThat(actual).isEqualTo(expected)
    }

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

    @Test
    fun id_escapeSlash() {
        val target1 = CatalogItemIdentifier(
            parents = listOf("Parent"),
            name = "Item",
            count = 0
        )
        val target2 = CatalogItemIdentifier(
            parents = listOf(),
            name = "Parent/Item",
            count = 0
        )
        assertThat(target1.id).isNotEqualTo(target2.id)
        assertThat(target1.id).isEqualTo("/Parent/Item")
        assertThat(target2.id).isEqualTo("/Parent%2FItem")
    }

    @Test
    fun id_escapeParentheses() {
        val target1 = CatalogItemIdentifier(
            parents = listOf(),
            name = "Item",
            count = 1
        )
        val target2 = CatalogItemIdentifier(
            parents = listOf(),
            name = "Item(2)",
            count = 0
        )
        assertThat(target1.id).isNotEqualTo(target2.id)
        assertThat(target1.id).isEqualTo("/Item(2)")
        assertThat(target2.id).isEqualTo("/Item%282%29")
    }

    @Test
    fun id_escapePercent() {
        val target1 = CatalogItemIdentifier(
            parents = listOf(),
            name = "Parent/Item",
            count = 0
        )
        val target2 = CatalogItemIdentifier(
            parents = listOf(),
            name = "Parent%2FItem",
            count = 0
        )
        assertThat(target1.id).isNotEqualTo(target2.id)
        assertThat(target1.id).isEqualTo("/Parent%2FItem")
        assertThat(target2.id).isEqualTo("/Parent%252FItem")
    }

    @Test
    fun equals_true() {
        val target1 = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 0
        )
        val target2 = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 0
        )
        val actual = target1 == target2
        assertThat(actual).isTrue()
    }

    @Test
    fun equals_false() {
        val target1 = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 0
        )
        val target2 = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 1
        )
        val actual = target1 == target2
        assertThat(actual).isFalse()
    }

    @Test
    fun equals_ignoreCount() {
        val target1 = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 0
        )
        val target2 = CatalogItemIdentifier(
            parents = listOf("Group1", "Group2"),
            name = "Item",
            count = 1
        )
        val actual = target1.equals(target2, ignoreCount = true)
        assertThat(actual).isTrue()
    }
}
