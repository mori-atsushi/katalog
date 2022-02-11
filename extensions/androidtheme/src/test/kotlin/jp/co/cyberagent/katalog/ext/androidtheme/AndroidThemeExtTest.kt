package jp.co.cyberagent.katalog.ext.androidtheme

import android.content.Context
import android.content.ContextWrapper
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import jp.co.cyberagent.katalog.KatalogApp
import jp.co.cyberagent.katalog.ext.androidtheme.internal.getAttributeColor
import jp.co.cyberagent.katalog.ext.androidtheme.test.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class AndroidThemeExtTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun colors() {
        var context: Context? = null
        composeRule.setContent {
            KatalogApp(
                extensions = listOf(AndroidThemeExt(R.style.Theme_AppCompatTestTheme))
            ) {
                compose("Sample") {
                    context = LocalContext.current
                }
            }
        }
        assertThat(context).isInstanceOf(ContextWrapper::class.java)
        val primaryColor = context?.getAttributeColor(android.R.attr.colorPrimary)?.let {
            Color(it)
        }
        assertThat(primaryColor).isEqualTo(Color.Red)
        val backgroundColor = context?.getAttributeColor(android.R.attr.colorBackground)?.let {
            Color(it)
        }
        assertThat(backgroundColor).isEqualTo(Color.White)
    }
}
