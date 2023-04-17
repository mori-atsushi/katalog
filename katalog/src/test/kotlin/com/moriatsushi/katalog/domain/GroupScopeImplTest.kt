package com.moriatsushi.katalog.domain

import androidx.compose.material.Text
import com.google.common.truth.Truth.assertThat
import com.moriatsushi.katalog.dsl.GroupDefinition
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class GroupScopeImplTest {
    @Test
    fun id() {
        val definition: GroupDefinition = {
            compose("Text") {
                Text("sample")
            }
        }
        val target = GroupScopeImpl()
        target.definition()
        val item = target.items.first()
        assertThat(item.id).isEqualTo("/Text")
    }

    @Test
    fun id_nested() {
        val definition: GroupDefinition = {
            group("Group1") {
                group("Group2") {
                    compose("Text") {
                        Text("sample")
                    }
                }
            }
        }
        val target = GroupScopeImpl()
        target.definition()
        val item1 = target.items.first() as CatalogItem.Group
        assertThat(item1.id).isEqualTo("/Group1")
        val item2 = item1.items.first() as CatalogItem.Group
        assertThat(item2.id).isEqualTo("/Group1/Group2")
        val item3 = item2.items.first()
        assertThat(item3.id).isEqualTo("/Group1/Group2/Text")
    }

    @Test
    fun id_duplicate() {
        val definition: GroupDefinition = {
            compose("Text") {
                Text("sample1")
            }
            compose("Text") {
                Text("sample2")
            }
            compose("Text") {
                Text("sample3")
            }
        }
        val target = GroupScopeImpl()
        target.definition()
        val item1 = target.items[0]
        assertThat(item1.id).isEqualTo("/Text")
        val item2 = target.items[1]
        assertThat(item2.id).isEqualTo("/Text(2)")
        val item3 = target.items[2]
        assertThat(item3.id).isEqualTo("/Text(3)")
    }

    @Test
    fun id_duplicateGroup() {
        val definition: GroupDefinition = {
            group("Group") {
                compose("Text") {
                    Text("sample1")
                }
            }
            group("Group") {
                compose("Text") {
                    Text("sample2")
                }
            }
            group("Group") {
                compose("Text") {
                    Text("sample3")
                }
            }
        }
        val target = GroupScopeImpl()
        target.definition()
        val item1 = (target.items[0] as CatalogItem.Group).items[0]
        assertThat(item1.id).isEqualTo("/Group/Text")
        val item2 = (target.items[1] as CatalogItem.Group).items[0]
        assertThat(item2.id).isEqualTo("/Group(2)/Text")
        val item3 = (target.items[2] as CatalogItem.Group).items[0]
        assertThat(item3.id).isEqualTo("/Group(3)/Text")
    }

    @Test
    fun id_duplicate_escaped() {
        val definition: GroupDefinition = {
            group("Parent") {
                compose("Item") {
                    Text("sample1")
                }
            }
            compose("Parent/Item") {
                Text("sample2")
            }
            compose("Parent%2FItem") {
                Text("sample3")
            }
        }
        val target = GroupScopeImpl()
        target.definition()
        val item1 = (target.items[0] as CatalogItem.Group).items[0]
        assertThat(item1.id).isEqualTo("/Parent/Item")
        val item2 = target.items[1]
        assertThat(item2.id).isEqualTo("/Parent%2FItem")
        val item3 = target.items[2]
        assertThat(item3.id).isEqualTo("/Parent%252FItem")
    }
}
