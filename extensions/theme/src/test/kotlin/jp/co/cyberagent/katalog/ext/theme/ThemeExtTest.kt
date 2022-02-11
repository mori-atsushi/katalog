package jp.co.cyberagent.katalog.ext.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import jp.co.cyberagent.katalog.KatalogApp
import jp.co.cyberagent.katalog.ext.KatalogExt
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ThemeExtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun colors() {
        var colors: Colors? = null
        composeTestRule.setContent {
            KatalogApp(
                extensions = listOf(dummyThemeExt())
            ) {
                compose("Hello, World") {
                    colors = MaterialTheme.colors
                }
            }
        }
        assertThat(colors?.primary).isEqualTo(Color.Red)
        assertThat(colors?.background).isEqualTo(Color.White)
        assertThat(colors?.isLight).isTrue()
    }

    private fun dummyThemeExt(): KatalogExt {
        return ThemeExt { content ->
            MaterialTheme(
                colors = lightColors(
                    primary = Color.Red,
                    background = Color.White
                ),
                content = content
            )
        }
    }
}
