package jp.co.cyberagent.katalog.domain

import com.google.common.truth.Truth.assertThat
import jp.co.cyberagent.katalog.group
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class KatalogTest {
    @Test
    fun create() {
        Katalog.register(
            title = "title",
            extensions = emptyList()
        ) {
            group("group1") {
                group("group1-1") {
                    compose("view1-1-1") {
                    }
                }
                compose("view1-1") {
                }
            }
            group("group2") {
                compose("view2-1") {
                }
                compose("view2-2") {
                }
            }
            compose("view1") {
            }
        }
        val catalog = Katalog.create()
        assertThat(catalog.title).isEqualTo("title")
        assertThat(catalog.items).hasSize(3)
        catalog.items[0].also {
            assertThat(it.name).isEqualTo("group1")
            assertThat(it).isInstanceOf(CatalogItem.Group::class.java)
            assertThat((it as CatalogItem.Group).items).hasSize(2)
        }
        catalog.items[1].also {
            assertThat(it.name).isEqualTo("group2")
            assertThat(it).isInstanceOf(CatalogItem.Group::class.java)
            assertThat((it as CatalogItem.Group).items).hasSize(2)
        }
        catalog.items[2].also {
            assertThat(it.name).isEqualTo("view1")
            assertThat(it).isInstanceOf(CatalogItem.Component::class.java)
        }
    }

    @Test
    fun create_group() {
        val group1 = group("group1") {
            compose("view1-1") {
            }
            compose("view1-2") {
            }
        }
        val group2 = group("group2") {
            compose("view2-1") {
            }
        }
        Katalog.register(
            title = "title",
            extensions = emptyList()
        ) {
            group(group1, group2)
        }

        val catalog = Katalog.create()
        assertThat(catalog.items).hasSize(2)
        catalog.items[0].also {
            assertThat(it.name).isEqualTo("group1")
            assertThat(it).isInstanceOf(CatalogItem.Group::class.java)
            assertThat((it as CatalogItem.Group).items).hasSize(2)
        }
        catalog.items[1].also {
            assertThat(it.name).isEqualTo("group2")
            assertThat(it).isInstanceOf(CatalogItem.Group::class.java)
            assertThat((it as CatalogItem.Group).items).hasSize(1)
        }
    }

    @Test
    fun create_notSet() {
        Katalog.register(
            title = "title",
            extensions = emptyList()
        ) {
            // no op
        }
        val catalog = Katalog.create()
        assertThat(catalog.items).isEmpty()
    }
}
