package com.moriatsushi.katalog.androidsample

import android.app.Application
import com.moriatsushi.katalog.androidsample.compose.material.composeMaterialGroup
import com.moriatsushi.katalog.androidsample.fragment.fragmentGroup
import com.moriatsushi.katalog.androidsample.view.material.viewMaterialGroup
import com.moriatsushi.katalog.ext.androidtheme.AndroidThemeExt
import com.moriatsushi.katalog.ext.pagesaver.PageSaverExt
import com.moriatsushi.katalog.ext.theme.ThemeExt
import com.moriatsushi.katalog.registerKatalog
import com.google.android.material.R as MaterialR

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        registerKatalog(
            title = "Android Sample",
            extensions = listOf(
                AndroidThemeExt(MaterialR.style.Theme_MaterialComponents_DayNight_NoActionBar),
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
