package jp.co.cyberagent.katalog.compose.navigation

import androidx.compose.material.Text
import com.google.common.truth.Truth.assertThat
import jp.co.cyberagent.katalog.domain.CatalogItem
import jp.co.cyberagent.katalog.domain.dummyKatalog
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@ExperimentalKatalogExtApi
@RunWith(JUnit4::class)
internal class ExtNavStateImplTest {
    @Test
    fun backStack() {
        val katalog = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text(text = "Sample")
                }
            }
        }
        val navController = createMainNavController()
        val target = ExtNavStateImpl(
            navController = navController,
            katalog = katalog
        )
        assertThat(target.backStack).isEqualTo(listOf("/"))
        assertThat(target.current).isEqualTo("/")

        val next1 = katalog.items.first() as CatalogItem.Group
        navController.navigateTo(next1)
        assertThat(target.backStack).isEqualTo(listOf("/", "/Group"))
        assertThat(target.current).isEqualTo("/Group")

        val next2 = next1.items.first() as CatalogItem.Component
        navController.navigateTo(next2)
        assertThat(target.backStack).isEqualTo(listOf("/", "/Group", "/Group/Item"))
        assertThat(target.current).isEqualTo("/Group/Item")
    }

    @Test
    fun navigateTo() = runTest {
        val katalog = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text(text = "Sample")
                }
            }
        }
        val navController = createMainNavController()
        val target = ExtNavStateImpl(
            navController = navController,
            katalog = katalog
        )
        val actual = target.navigateTo("/Group/Item")
        assertThat(actual).isTrue()
        assertThat(target.current).isEqualTo("/Group/Item")
    }

    @Test
    fun navigateTo_invalid() = runTest {
        val katalog = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text(text = "Sample")
                }
            }
        }
        val navController = createMainNavController()
        val target = ExtNavStateImpl(
            navController = navController,
            katalog = katalog
        )
        val actual = target.navigateTo("/invalid")
        assertThat(actual).isFalse()
        assertThat(target.current).isEqualTo("/")
    }

    @Test
    fun navigateTo_top() = runTest {
        val katalog = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text(text = "Sample")
                }
            }
        }
        val navController = createMainNavController()
        val target = ExtNavStateImpl(
            navController = navController,
            katalog = katalog
        )
        val actual = target.navigateTo("/")
        assertThat(actual).isTrue()
        assertThat(target.backStack).isEqualTo(listOf("/", "/"))
    }

    @Test
    fun restore() = runTest {
        val katalog = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text(text = "Sample")
                }
            }
        }
        val navController = createMainNavController()
        val target = ExtNavStateImpl(
            navController = navController,
            katalog = katalog
        )
        val actual = target.restore(listOf("/", "/Group", "/Group/Item"))
        assertThat(actual).isTrue()
        assertThat(target.backStack).isEqualTo(listOf("/", "/Group", "/Group/Item"))
    }

    @Test
    fun restore_nested() = runTest {
        val katalog = dummyKatalog {
            group("Group1") {
                group("Group2") {
                    compose("Item") {
                        Text(text = "Sample")
                    }
                }
            }
        }
        val navController = createMainNavController()
        val target = ExtNavStateImpl(
            navController = navController,
            katalog = katalog
        )
        val actual = target.restore(listOf("/", "/Group1", "/Group1/Group2"))
        assertThat(actual).isTrue()
        assertThat(target.backStack).isEqualTo(listOf("/", "/Group1", "/Group1/Group2"))
    }

    @Test
    fun restore_invalid() = runTest {
        val katalog = dummyKatalog {
            group("Group") {
                compose("Item") {
                    Text(text = "Sample")
                }
            }
        }
        val navController = createMainNavController()
        val target = ExtNavStateImpl(
            navController = navController,
            katalog = katalog
        )
        val actual = target.restore(listOf("/", "/invalid", "/Group/Item"))
        assertThat(actual).isFalse()
        assertThat(target.backStack).isEqualTo(listOf("/"))
    }
}
