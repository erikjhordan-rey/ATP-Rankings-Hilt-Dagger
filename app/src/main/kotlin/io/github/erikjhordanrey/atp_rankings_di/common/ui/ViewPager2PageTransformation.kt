package io.github.erikjhordanrey.atp_rankings_di.common.ui

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class ViewPager2PageTransformation : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            translationY = abs(position) * 500f
            scaleX = 1f
            scaleY = 1f
        }
    }
}
