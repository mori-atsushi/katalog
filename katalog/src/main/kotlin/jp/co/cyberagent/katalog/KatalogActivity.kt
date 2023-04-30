package jp.co.cyberagent.katalog

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.moriatsushi.katalog.compose.App

@Deprecated(
    "The package name has changed.",
    ReplaceWith("KatalogActivity", "com.moriatsushi.katalog.KatalogActivity"),
)
public class KatalogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                window = window,
            )
        }
    }
}
