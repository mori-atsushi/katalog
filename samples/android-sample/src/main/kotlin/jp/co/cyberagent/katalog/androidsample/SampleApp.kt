package jp.co.cyberagent.katalog.androidsample

import android.app.Application
import jp.co.cyberagent.katalog.androidsample.compose.material.composeMaterialGroup
import jp.co.cyberagent.katalog.androidsample.fragment.fragmentGroup
import jp.co.cyberagent.katalog.androidsample.view.material.viewMaterialGroup
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
