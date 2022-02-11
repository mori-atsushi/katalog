package jp.co.cyberagent.katalog.ext.pagesaver

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import jp.co.cyberagent.katalog.KatalogApp
import jp.co.cyberagent.katalog.ext.pagesaver.internal.DummyLocalStorage
import jp.co.cyberagent.katalog.ext.pagesaver.internal.LocalStorage
import jp.co.cyberagent.katalog.ext.pagesaver.internal.PageStore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class PageSaverExtTest {
    @get:Rule
    val composeRule = createEmptyComposeRule()

    @Test
    fun saveAndRestore() {
        val localStorage = DummyLocalStorage()
        // launch activity
        val scenario1 = launchActivity<ComponentActivity>()
        scenario1.onActivity {
            it.setContent {
                DummyKatalogApp(localStorage)
            }
        }
        // navigate to /Group/Item
        composeRule.onNodeWithText("Item").performClick()
        composeRule.onNodeWithText("Title").assertDoesNotExist()
        composeRule.onNodeWithText("Group").assertDoesNotExist()
        composeRule.onNodeWithText("Item").assertExists()
        composeRule.onNodeWithText("Sample").assertExists()

        // finish activity
        scenario1.moveToState(Lifecycle.State.DESTROYED)

        // launch other activity
        val scenario2 = launchActivity<ComponentActivity>()
        scenario2.onActivity {
            it.setContent {
                DummyKatalogApp(localStorage)
            }
        }

        // restore previous page
        composeRule.onNodeWithText("Title").assertDoesNotExist()
        composeRule.onNodeWithText("Group").assertDoesNotExist()
        composeRule.onNodeWithText("Item").assertExists()
        composeRule.onNodeWithText("Sample").assertExists()
    }

    @Test
    fun notFound() {
        val localStorage = DummyLocalStorage()
        // launch activity
        val scenario1 = launchActivity<ComponentActivity>()
        scenario1.onActivity {
            it.setContent {
                DummyKatalogApp(localStorage)
            }
        }
        // navigate to /Group/Item
        composeRule.onNodeWithText("Item").performClick()
        composeRule.onNodeWithText("Title").assertDoesNotExist()
        composeRule.onNodeWithText("Group").assertDoesNotExist()
        composeRule.onNodeWithText("Item").assertExists()
        composeRule.onNodeWithText("Sample").assertExists()

        // finish activity
        scenario1.moveToState(Lifecycle.State.DESTROYED)

        // launch other activity
        val scenario2 = launchActivity<ComponentActivity>()
        scenario2.onActivity {
            it.setContent {
                OtherKatalogApp(localStorage)
            }
        }

        // restore previous page
        composeRule.onNodeWithText("Title").assertExists()
        composeRule.onNodeWithText("OtherGroup").assertExists()
        composeRule.onNodeWithText("OtherItem").assertExists()
        composeRule.onNodeWithText("OtherSample").assertExists()
    }

    @Composable
    private fun DummyKatalogApp(
        localStorage: LocalStorage
    ) {
        val pageStore = remember { PageStore(localStorage) }
        KatalogApp(
            title = "Title",
            extensions = listOf(PageSaverExt(pageStore))
        ) {
            group("Group") {
                compose("Item") {
                    BasicText(text = "Sample")
                }
            }
        }
    }

    @Composable
    private fun OtherKatalogApp(
        localStorage: LocalStorage
    ) {
        val pageStore = remember { PageStore(localStorage) }
        KatalogApp(
            title = "Title",
            extensions = listOf(PageSaverExt(pageStore))
        ) {
            group("OtherGroup") {
                compose("OtherItem") {
                    BasicText(text = "OtherSample")
                }
            }
        }
    }
}
