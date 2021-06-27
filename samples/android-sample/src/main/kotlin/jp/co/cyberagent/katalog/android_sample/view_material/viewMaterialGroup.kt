package jp.co.cyberagent.katalog.android_sample.view_material

import jp.co.cyberagent.katalog.android_sample.databinding.MaterialAppBarsBottomBinding
import jp.co.cyberagent.katalog.dsl.MATCH_WIDTH_MATCH_HEIGHT
import jp.co.cyberagent.katalog.dsl.binding
import jp.co.cyberagent.katalog.group

val viewMaterialGroup = group("View Material") {
    binding(
        factory = MaterialAppBarsBottomBinding::inflate,
        name = "App bars: bottom",
        layoutParams = MATCH_WIDTH_MATCH_HEIGHT
    )
}
