package jp.co.cyberagent.katalog.compose

import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import jp.co.cyberagent.katalog.domain.DefaultKatalogContainer
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class AppTest {
    @get:Rule
    val composeTest = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun start() {
        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                container = createSimpleContainer()
            )
        }
        composeTest.onNodeWithText("Title").assertExists()
        composeTest.onNodeWithText("Group").assertExists()
        composeTest.onNodeWithText("Item").assertExists()
        composeTest.onNodeWithText("Sample").assertExists()
    }

    @Test
    fun start_notRegistered() {
        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                container = DefaultKatalogContainer()
            )
        }
        composeTest.onNodeWithText("Please call registerKatalog method.").assertExists()
    }

    @Test
    fun navigateToGroup() {
        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                container = createSimpleContainer()
            )
        }
        composeTest.onNodeWithText("Group").performClick()
        composeTest.onNodeWithText("Title").assertDoesNotExist()
        composeTest.onNodeWithText("Group").assertExists()
        composeTest.onNodeWithText("Item").assertExists()
        composeTest.onNodeWithText("Sample").assertExists()
    }

    @Test
    fun navigateToItem() {
        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                container = createSimpleContainer()
            )
        }
        composeTest.onNodeWithText("Item").performClick()
        composeTest.onNodeWithText("Title").assertDoesNotExist()
        composeTest.onNodeWithText("Group").assertDoesNotExist()
        composeTest.onNodeWithText("Item").assertExists()
        composeTest.onNodeWithText("Sample").assertExists()
    }

    private fun createSimpleContainer(): DefaultKatalogContainer {
        val container = DefaultKatalogContainer()
        container.register(
            title = "Title",
            extensions = listOf()
        ) {
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
            }
        }
        return container
    }
}
