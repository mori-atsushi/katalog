package jp.co.cyberagent.katalog.androidsample

import android.app.Application
import jp.co.cyberagent.katalog.androidsample.compose.material.composeMaterialGroup
import jp.co.cyberagent.katalog.androidsample.fragment.fragmentGroup
import jp.co.cyberagent.katalog.androidsample.view.material.viewMaterialGroup
import jp.co.cyberagent.katalog.ext.androidtheme.AndroidThemeExt
import jp.co.cyberagent.katalog.ext.pagesaver.PageSaverExt
import jp.co.cyberagent.katalog.ext.theme.ThemeExt
import jp.co.cyberagent.katalog.registerKatalog

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        registerKatalog(
            title = "Android Sample",
            extensions = listOf(
                AndroidThemeExt(R.style.Theme_MaterialComponents_DayNight_NoActionBar),
                ThemeExt { SampleTheme(it) },
                PageSaverExt()
            )
        ) {
            group(
                composeMaterialGroup,
                viewMaterialGroup,
                fragmentGroup
            )
        }
    }
}
