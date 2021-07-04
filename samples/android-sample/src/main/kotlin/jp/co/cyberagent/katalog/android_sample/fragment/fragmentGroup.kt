package jp.co.cyberagent.katalog.android_sample.fragment

import jp.co.cyberagent.katalog.dsl.fragment
import jp.co.cyberagent.katalog.group

val fragmentGroup = group("Fragment") {
    fragment {
        SampleFragment()
    }
}
