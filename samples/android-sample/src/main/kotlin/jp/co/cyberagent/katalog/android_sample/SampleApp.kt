package jp.co.cyberagent.katalog.android_sample

import android.app.Application
import jp.co.cyberagent.katalog.startKatalog

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKatalog {
            title = "Android Sample"
        }
    }
}
