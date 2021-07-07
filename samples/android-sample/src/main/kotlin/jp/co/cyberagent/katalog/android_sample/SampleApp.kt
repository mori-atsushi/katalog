package jp.co.cyberagent.katalog.android_sample

import android.app.Application
import jp.co.cyberagent.katalog.android_sample.compose_material.composeMaterialGroup
import jp.co.cyberagent.katalog.android_sample.fragment.fragmentGroup
import jp.co.cyberagent.katalog.android_sample.view_material.viewMaterialGroup
import jp.co.cyberagent.katalog.registerKatalog

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        registerKatalog(
            title = "Android Sample"
        ) {
            group(
                composeMaterialGroup,
                viewMaterialGroup,
                fragmentGroup
            )
        }
    }
}
