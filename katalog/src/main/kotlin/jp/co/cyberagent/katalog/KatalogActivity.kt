package jp.co.cyberagent.katalog

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import jp.co.cyberagent.katalog.compose.App

class KatalogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                window = window,
                fragmentManager = supportFragmentManager
            )
        }
    }
}
