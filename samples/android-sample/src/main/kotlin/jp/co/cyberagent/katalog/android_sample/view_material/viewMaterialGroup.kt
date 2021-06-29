package jp.co.cyberagent.katalog.android_sample.view_material

import jp.co.cyberagent.katalog.android_sample.databinding.MaterialAppBarsBottomBinding
import jp.co.cyberagent.katalog.android_sample.databinding.MaterialAppBarsTopBinding
import jp.co.cyberagent.katalog.android_sample.databinding.MaterialAppBarsTopProminentBinding
import jp.co.cyberagent.katalog.dsl.MATCH_WIDTH_MATCH_HEIGHT
import jp.co.cyberagent.katalog.dsl.MATCH_WIDTH_WRAP_HEIGHT
import jp.co.cyberagent.katalog.dsl.binding
import jp.co.cyberagent.katalog.dsl.view
import jp.co.cyberagent.katalog.group

val viewMaterialGroup = group("View Material") {
    binding(
        factory = MaterialAppBarsBottomBinding::inflate,
        name = "App bars: bottom",
        layoutParams = MATCH_WIDTH_MATCH_HEIGHT
    )
    group("App bars: top") {
        binding(
            factory = MaterialAppBarsTopBinding::inflate,
            name = "App bars: top",
            layoutParams = MATCH_WIDTH_MATCH_HEIGHT
        )
        binding(
            factory = MaterialAppBarsTopProminentBinding::inflate,
            name = "App bars: top - prominent",
            layoutParams = MATCH_WIDTH_MATCH_HEIGHT
        )
    }
    group("Bottom navigation") {
        view(
            name = "Bottom navigation",
            layoutParams = MATCH_WIDTH_WRAP_HEIGHT
        ) {
            getSampleBottomNavigation(it)
        }
        view(
            name = "Bottom navigation with badges",
            layoutParams = MATCH_WIDTH_WRAP_HEIGHT
        ) {
            getSampleBottomNavigationWithBadges(it)
        }
    }
}
