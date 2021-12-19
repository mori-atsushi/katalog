package jp.co.cyberagent.katalog.ext.pagesaver.internal

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalKatalogExtApi
@RunWith(AndroidJUnit4::class)
internal class PageSaverTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun save() {
        val navState = DummyExtNavState()
        val pageStore = PageStore(
            DummyLocalStorage()
        )
        assertThat(pageStore.read()).isNull()

        composeTestRule.setContent {
            PageSaver(
                navState = navState,
                pageStore = pageStore
            )
        }
        composeTestRule.waitForIdle()
        assertThat(pageStore.read()).isEqualTo(listOf("/"))

        navState.navigateTo("/Group")
        navState.navigateTo("/Group/Item")

        composeTestRule.waitForIdle()
        assertThat(pageStore.read()).isEqualTo(listOf("/", "/Group", "/Group/Item"))
    }

    @Test
    fun restore() {
        val navState = DummyExtNavState()
        val pageStore = PageStore(
            DummyLocalStorage()
        )
        pageStore.update(listOf("/", "/Group", "/Group/Item"))
        assertThat(navState.backStack).isEqualTo(listOf("/"))

        composeTestRule.setContent {
            PageSaver(
                navState = navState,
                pageStore = pageStore
            )
        }
        composeTestRule.waitForIdle()
        assertThat(navState.backStack).isEqualTo(listOf("/", "/Group", "/Group/Item"))
    }
}
