package jp.co.cyberagent.katalog.compose

import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import jp.co.cyberagent.katalog.domain.DefaultKatalogContainer
import jp.co.cyberagent.katalog.ext.ExperimentalKatalogExtApi
import jp.co.cyberagent.katalog.ext.KatalogExt
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalKatalogExtApi::class)
internal class ExtNavStateTest {
    @get:Rule
    val composeTest = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun navigateTo_group() {
        var result: Boolean? = null
        val extension = KatalogExt.Builder("Sample")
            .setRootWrapper { content ->
                LaunchedEffect(Unit) {
                    result = navState.navigateTo("/Group")
                }
                content()
            }
            .build()

        setupSimple(listOf(extension))

        assertThat(result).isTrue()
        composeTest.onNodeWithText("Title").assertDoesNotExist()
        composeTest.onNodeWithText("Group").assertExists()
        composeTest.onNodeWithText("Item").assertExists()
        composeTest.onNodeWithText("Sample").assertExists()
    }

    @Test
    fun navigateTo_item() {
        var result: Boolean? = null
        val extension = KatalogExt.Builder("Sample")
            .setRootWrapper { content ->
                LaunchedEffect(Unit) {
                    result = navState.navigateTo("/Group/Item")
                }
                content()
            }
            .build()

        setupSimple(listOf(extension))

        assertThat(result).isTrue()
        composeTest.onNodeWithText("Title").assertDoesNotExist()
        composeTest.onNodeWithText("Group").assertDoesNotExist()
        composeTest.onNodeWithText("Item").assertExists()
        composeTest.onNodeWithText("Sample").assertExists()
    }

    @Test
    fun navigateTo_notFound() {
        var result: Boolean? = null
        val extension = KatalogExt.Builder("Sample")
            .setRootWrapper { content ->
                LaunchedEffect(Unit) {
                    result = navState.navigateTo("/Invalid")
                }
                content()
            }
            .build()

        setupSimple(listOf(extension))

        assertThat(result).isFalse()
        composeTest.onNodeWithText("Title").assertExists()
        composeTest.onNodeWithText("Group").assertExists()
        composeTest.onNodeWithText("Item").assertExists()
        composeTest.onNodeWithText("Sample").assertExists()
    }

    private fun setupSimple(
        extensions: List<KatalogExt> = listOf()
    ) {
        val container = DefaultKatalogContainer()
        container.register(
            title = "Title",
            extensions = extensions
        ) {
            group("Group") {
                compose("Item") {
                    Text("Sample")
                }
            }
        }
        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                container = container
            )
        }
    }
}
