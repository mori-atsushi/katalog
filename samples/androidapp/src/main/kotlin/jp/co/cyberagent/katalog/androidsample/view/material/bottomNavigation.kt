package jp.co.cyberagent.katalog.androidsample.view.material

import android.content.Context
import com.google.android.material.bottomnavigation.BottomNavigationView
import jp.co.cyberagent.katalog.androidsample.R

fun getSampleBottomNavigation(context: Context): BottomNavigationView {
    val view = BottomNavigationView(context)
    view.inflateMenu(R.menu.bottom_navigation_menu)
    return view
}

fun getSampleBottomNavigationWithBadges(context: Context): BottomNavigationView {
    val view = BottomNavigationView(context)
    view.inflateMenu(R.menu.bottom_navigation_menu)
    view.getOrCreateBadge(R.id.page_1).also {
        it.isVisible = true
    }
    view.getOrCreateBadge(R.id.page_2).also {
        it.isVisible = true
        it.number = 99
    }

    view.getOrCreateBadge(R.id.page_3).also {
        it.isVisible = true
        it.number = 1000
    }
    return view
}
