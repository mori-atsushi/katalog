package com.moriatsushi.katalog.androidsample.view.material

import com.moriatsushi.katalog.androidsample.databinding.MaterialAppBarsBottomBinding
import com.moriatsushi.katalog.androidsample.databinding.MaterialAppBarsTopBinding
import com.moriatsushi.katalog.androidsample.databinding.MaterialAppBarsTopProminentBinding
import com.moriatsushi.katalog.dsl.MATCH_WIDTH_MATCH_HEIGHT
import com.moriatsushi.katalog.dsl.MATCH_WIDTH_WRAP_HEIGHT
import com.moriatsushi.katalog.dsl.binding
import com.moriatsushi.katalog.dsl.view
import com.moriatsushi.katalog.group

val viewMaterialGroup = group("View Material") {
    binding(
        factory = MaterialAppBarsBottomBinding::inflate,
        name = "App bars: bottom",
        layoutParams = MATCH_WIDTH_MATCH_HEIGHT,
    )
    group("App bars: top") {
        binding(
            factory = MaterialAppBarsTopBinding::inflate,
            name = "App bars: top",
            layoutParams = MATCH_WIDTH_MATCH_HEIGHT,
        )
        binding(
            factory = MaterialAppBarsTopProminentBinding::inflate,
            name = "App bars: top - prominent",
            layoutParams = MATCH_WIDTH_MATCH_HEIGHT,
        )
    }
    group("Bottom navigation") {
        view(
            name = "Bottom navigation",
            layoutParams = MATCH_WIDTH_WRAP_HEIGHT,
        ) {
            getSampleBottomNavigation(context)
        }
        view(
            name = "Bottom navigation with badges",
            layoutParams = MATCH_WIDTH_WRAP_HEIGHT,
        ) {
            getSampleBottomNavigationWithBadges(context)
        }
    }
}
