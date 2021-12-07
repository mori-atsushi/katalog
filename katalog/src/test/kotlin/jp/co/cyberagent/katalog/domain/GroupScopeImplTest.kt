package jp.co.cyberagent.katalog.domain

import androidx.compose.material.Text
import com.google.common.truth.Truth.assertThat
import jp.co.cyberagent.katalog.dsl.GroupDefinition
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
}
