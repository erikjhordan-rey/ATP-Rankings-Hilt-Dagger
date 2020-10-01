package io.github.erikjhordanrey.atp_rankings_di.core.extension

import android.view.View
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

fun ViewPager2.compositeScaleTransform() {
    setPageTransformer(CompositePageTransformer().also {
        it.addTransformer(MarginPageTransformer(MARGIN_PAGE))
        it.addTransformer(ScaleTransformation())
    })
}

class ScaleTransformation : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            translationY = abs(position) * TRANSLATION
            scaleX = SCALE_SIZE
            scaleY = SCALE_SIZE
        }
    }
}

private const val MARGIN_PAGE = 50
private const val TRANSLATION = 500f
private const val SCALE_SIZE = 1f
