package com.moriatsushi.katalog.domain

import com.google.common.truth.Truth.assertThat
import com.moriatsushi.katalog.group
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class KatalogContainerTest {
    private lateinit var target: KatalogContainer

    @Before
    fun setup() {
        target = KatalogContainer()
    }

    @Test
    fun create() {
        target.register(
            title = "title",
            extensions = emptyList(),
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
        val katalog = target.create()
        assertThat(katalog.title).isEqualTo("title")
        assertThat(katalog.items).hasSize(3)
        katalog.items[0].also {
            assertThat(it.name).isEqualTo("group1")
            assertThat(it).isInstanceOf(CatalogItem.Group::class.java)
            assertThat((it as CatalogItem.Group).items).hasSize(2)
        }
        katalog.items[1].also {
            assertThat(it.name).isEqualTo("group2")
            assertThat(it).isInstanceOf(CatalogItem.Group::class.java)
            assertThat((it as CatalogItem.Group).items).hasSize(2)
        }
        katalog.items[2].also {
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
        target.register(
            title = "title",
            extensions = emptyList(),
        ) {
            group(group1, group2)
        }

        val katalog = target.create()
        assertThat(katalog.items).hasSize(2)
        katalog.items[0].also {
            assertThat(it.name).isEqualTo("group1")
            assertThat(it).isInstanceOf(CatalogItem.Group::class.java)
            assertThat((it as CatalogItem.Group).items).hasSize(2)
        }
        katalog.items[1].also {
            assertThat(it.name).isEqualTo("group2")
            assertThat(it).isInstanceOf(CatalogItem.Group::class.java)
            assertThat((it as CatalogItem.Group).items).hasSize(1)
        }
    }

    @Test
    fun create_empty() {
        target.register(
            title = "title",
            extensions = emptyList(),
        ) {
            // no op
        }
        val kaalog = target.create()
        assertThat(kaalog.items).isEmpty()
    }

    @Test(expected = NotRegisteredException::class)
    fun create_notRegister() {
        target.create()
    }

    @Test(expected = AlreadyRegisteredException::class)
    fun create_duplicated() {
        target.register(
            title = "title1",
            extensions = emptyList(),
        ) {
            // no op
        }
        target.register(
            title = "title2",
            extensions = emptyList(),
        ) {
            // no op
        }
    }
}
