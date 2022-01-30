package jp.co.cyberagent.katalog.compose

import androidx.activity.ComponentActivity
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.test.junit4.createAndroidComposeRule
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
internal class ExtensionTest {
    @get:Rule
    val composeTest = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun setRootWrapper() {
        val extension = KatalogExt.Builder("Sample")
            .setRootWrapper { content ->
                CompositionLocalProvider(
                    LocalString provides "Provided",
                    content = content
                )
            }
            .build()
        val actual = getCurrentLocalString(listOf(extension))
        assertThat(actual).isEqualTo("Provided")
    }

    @Test
    fun setRootWrapper_multi() {
        val extension1 = KatalogExt.Builder("Sample")
            .setRootWrapper { content ->
                CompositionLocalProvider(
                    LocalString provides "Extension1",
                    content = content
                )
            }
            .build()
        val extension2 = KatalogExt.Builder("Sample")
            .setRootWrapper { content ->
                CompositionLocalProvider(
                    LocalString provides "Extension2",
                    content = content
                )
            }
            .build()
        val actual = getCurrentLocalString(
            listOf(extension1, extension2)
        )
        assertThat(actual).isEqualTo("Extension2")
    }

    @Test
    fun setComponentWrapper() {
        val extension = KatalogExt.Builder("Sample")
            .setRootWrapper { content ->
                CompositionLocalProvider(
                    LocalString provides "RootWrapper",
                    content = content
                )
            }
            .setComponentWrapper { content ->
                CompositionLocalProvider(
                    LocalString provides "ComponentWrapper",
                    content = content
                )
            }
            .build()
        val actual = getCurrentLocalString(listOf(extension))
        assertThat(actual).isEqualTo("ComponentWrapper")
    }

    @Test
    fun empty() {
        val actual = getCurrentLocalString(emptyList())
        assertThat(actual).isEqualTo("Default")
    }

    private fun getCurrentLocalString(extensions: List<KatalogExt>): String? {
        var actual: String? = null
        val container = DefaultKatalogContainer()
        container.register(
            title = "Title",
            extensions = extensions
        ) {
            compose("Text") {
                actual = LocalString.current
            }
        }
        composeTest.setContent {
            App(
                window = composeTest.activity.window,
                container = container
            )
        }
        return actual
    }

    private val LocalString = compositionLocalOf { "Default" }
}
