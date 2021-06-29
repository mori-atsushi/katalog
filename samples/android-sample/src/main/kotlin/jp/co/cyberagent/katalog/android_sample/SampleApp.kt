package jp.co.cyberagent.katalog.android_sample

import android.app.Application
import jp.co.cyberagent.katalog.android_sample.compose_material.composeMaterialGroup
import jp.co.cyberagent.katalog.android_sample.view_material.viewMaterialGroup
import jp.co.cyberagent.katalog.startKatalog

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKatalog {
            title = "Android Sample"
            group(composeMaterialGroup, viewMaterialGroup)
        }
    }
}
