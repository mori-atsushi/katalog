package com.moriatsushi.katalog.compose

import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.moriatsushi.katalog.domain.KatalogContainer
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class AppTest {
    @get:Rule
    val composeTest = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun start() {
        val viewModel = createSimpleKatalogViewModel()

        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                viewModel = viewModel,
            )
        }
        composeTest.onNodeWithText("Title").assertExists()
        composeTest.onNodeWithText("Group").assertExists()
        composeTest.onNodeWithText("Item").assertExists()
        composeTest.onNodeWithText("Sample").assertExists()
    }

    @Test
    fun start_notRegistered() {
        val container = KatalogContainer()
        val viewModel = KatalogViewModel(container)

        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                viewModel = viewModel,
            )
        }
        composeTest.onNodeWithText("Please call registerKatalog method.").assertExists()
    }

    @Test
    fun navigateToGroup() {
        val viewModel = createSimpleKatalogViewModel()

        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                viewModel = viewModel,
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
        val viewModel = createSimpleKatalogViewModel()

        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                viewModel = viewModel,
            )
        }
        composeTest.onNodeWithText("Item").performClick()
        composeTest.onNodeWithText("Title").assertDoesNotExist()
        composeTest.onNodeWithText("Group").assertDoesNotExist()
        composeTest.onNodeWithText("Item").assertExists()
        composeTest.onNodeWithText("Sample").assertExists()
    }

    private fun createSimpleKatalogViewModel(): KatalogViewModel {
        return dummyKatalogViewModel(
            title = "Title",
            extensions = listOf(),
        ) {
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
            }
        }
    }
}
