package com.moriatsushi.katalog.domain

import androidx.compose.material.Text
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class KatalogTest {
    @Test
    fun findItemById() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById("/Group1/Group2/Item")
        assertThat(actual).isInstanceOf(CatalogItem.Component::class.java)
        assertThat(actual?.id).isEqualTo("/Group1/Group2/Item")
    }

    @Test
    fun findItemById_group() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById("/Group1/Group2")
        assertThat(actual).isInstanceOf(CatalogItem.Group::class.java)
        assertThat(actual?.id).isEqualTo("/Group1/Group2")
    }

    @Test
    fun findItemById_notFoundParent() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById("/Other1/Other2/Item")
        assertThat(actual).isNull()
    }

    @Test
    fun findItemById_notFoundItem() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById("/Group1/Group2/Other")
        assertThat(actual).isNull()
    }

    @Test
    fun findItemById_notFoundCount() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById("/Group1/Group2/Item(2)")
        assertThat(actual?.id).isNull()
    }

    @Test
    fun findItemById_invalid() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById("invalid")
        assertThat(actual).isNull()
    }

    @Test
    fun findItemById_withCount() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById("/Group1/Group2/Item(2)")
        assertThat(actual?.id).isEqualTo("/Group1/Group2/Item(2)")
    }

    @Test
    fun findItemById_withCount_group() {
        val target = dummyKatalog {
            group("Group") {
                compose("Item1") {
                    Text("Sample")
                }
            }
            group("Group") {
                compose("Item2") {
                    Text("Sample")
                }
            }
        }
        val actual = target.findItemById("/Group(2)/Item2")
        assertThat(actual?.id).isEqualTo("/Group(2)/Item2")
    }

    @Test
    fun findItemById_ignoreCount() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById("/Group1/Group2/Item(2)", ignoreCount = true)
        assertThat(actual?.id).isEqualTo("/Group1/Group2/Item")
    }

    @Test
    fun findItemById_ignoreCount_group() {
        val target = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
            }
        }
        val actual = target.findItemById("/Group(2)/Item", ignoreCount = true)
        assertThat(actual?.id).isEqualTo("/Group/Item")
    }

    @Test
    fun findItemById_ignoreCount_exist() {
        val target = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text("Sample")
                    }
                    compose("Item") {
                        Text("Sample")
                    }
                }
            }
        }
        val actual = target.findItemById(
            "/Group1/Group2/Item(2)",
            ignoreCount = true,
        )
        assertThat(actual?.id).isEqualTo("/Group1/Group2/Item(2)")
    }

    @Test
    fun findItemById_ignoreCount_group_exist() {
        val target = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
            }
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
            }
        }
        val actual = target.findItemById("/Group(2)/Item", ignoreCount = true)
        assertThat(actual?.id).isEqualTo("/Group(2)/Item")
    }

    @Test
    fun findItemById_ignoreCount_nested1() {
        val target = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
            }
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
            }
        }
        val actual = target.findItemById("/Group(2)/Item(2)", ignoreCount = true)
        assertThat(actual?.id).isEqualTo("/Group(2)/Item")
    }

    @Test
    fun findItemById_ignoreCount_nested2() {
        val target = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
                compose("Item") {
                    Text("Sample")
                }
            }
        }
        val actual = target.findItemById("/Group(2)/Item(2)", ignoreCount = true)
        assertThat(actual?.id).isEqualTo("/Group/Item(2)")
    }
}
