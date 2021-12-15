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

        val parent1 = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Group1",
            count = 0
        )
        val parent2 = CatalogItemIdentifier(
            parents = listOf(parent1),
            name = "Group2",
            count = 0
        )
        val expected = CatalogItemIdentifier(
            parents = listOf(parent1, parent2),
            name = "Item",
            count = 0
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_withCount() {
        val target = "/Group1/Group2(2)/Item(3)"
        val actual = CatalogItemIdentifier.ofOrNull(target)

        val parent1 = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Group1",
            count = 0
        )
        val parent2 = CatalogItemIdentifier(
            parents = listOf(parent1),
            name = "Group2",
            count = 1
        )
        val expected = CatalogItemIdentifier(
            parents = listOf(parent1, parent2),
            name = "Item",
            count = 2
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_emptyName() {
        val target = "//"
        val actual = CatalogItemIdentifier.ofOrNull(target)

        val parent = CatalogItemIdentifier(
            parents = emptyList(),
            name = "",
            count = 0
        )
        val expected = CatalogItemIdentifier(
            parents = listOf(parent),
            name = "",
            count = 0
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_escapeSlash() {
        val target = "/Group1/Group2%2FItem"
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val parent = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Group1",
            count = 0
        )
        val expected = CatalogItemIdentifier(
            parents = listOf(parent),
            name = "Group2/Item",
            count = 0
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun ofOrNull_escapeParentheses() {
        val target = "/Group(2)/Item%282%29"
        val actual = CatalogItemIdentifier.ofOrNull(target)
        val parent = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Group",
            count = 1
        )
        val expected = CatalogItemIdentifier(
            parents = listOf(parent),
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
        val parent1 = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Group1",
            count = 0
        )
        val parent2 = CatalogItemIdentifier(
            parents = listOf(parent1),
            name = "Group2",
            count = 0
        )
        val target = CatalogItemIdentifier(
            parents = listOf(parent1, parent2),
            name = "Item",
            count = 0
        )
        val actual = target.id
        val expected = "/Group1/Group2/Item"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun id_withCount() {
        val parent1 = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Group1",
            count = 0
        )
        val parent2 = CatalogItemIdentifier(
            parents = listOf(parent1),
            name = "Group2",
            count = 1
        )
        val target = CatalogItemIdentifier(
            parents = listOf(parent1, parent2),
            name = "Item",
            count = 2
        )
        val actual = target.id
        val expected = "/Group1/Group2(2)/Item(3)"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun id_emptyName() {
        val parent = CatalogItemIdentifier(
            parents = emptyList(),
            name = "",
            count = 0
        )
        val target = CatalogItemIdentifier(
            parents = listOf(parent),
            name = "",
            count = 0
        )
        val actual = target.id
        val expected = "//"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun id_escapeSlash() {
        val parent = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Parent",
            count = 0
        )
        val target1 = CatalogItemIdentifier(
            parents = listOf(parent),
            name = "Item",
            count = 0
        )
        val target2 = CatalogItemIdentifier(
            parents = emptyList(),
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
        val parent1 = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Group1",
            count = 0
        )
        val parent2 = CatalogItemIdentifier(
            parents = listOf(parent1),
            name = "Group2",
            count = 0
        )
        val target1 = CatalogItemIdentifier(
            parents = listOf(parent1, parent2),
            name = "Item",
            count = 0
        )
        val target2 = CatalogItemIdentifier(
            parents = listOf(parent1, parent2),
            name = "Item",
            count = 0
        )
        val actual = target1 == target2
        assertThat(actual).isTrue()
    }

    @Test
    fun equals_false() {
        val parent1 = CatalogItemIdentifier(
            parents = emptyList(),
            name = "Group1",
            count = 0
        )
        val parent2 = CatalogItemIdentifier(
            parents = listOf(parent1),
            name = "Group2",
            count = 0
        )
        val target1 = CatalogItemIdentifier(
            parents = listOf(parent1, parent2),
            name = "Item",
            count = 0
        )
        val target2 = CatalogItemIdentifier(
            parents = listOf(parent1, parent2),
            name = "Item",
            count = 1
        )
        val actual = target1 == target2
        assertThat(actual).isFalse()
    }
}
