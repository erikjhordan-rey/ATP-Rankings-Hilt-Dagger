package io.github.erikjhordanrey.atp_rankings_di.matcher;

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

class ViewPagerItemsCountMatcher(private val expectedItemCount: Int) : BaseMatcher<View>() {

    override fun matches(item: Any?): Boolean {
        val viewPager = item as ViewPager2
        return viewPager.adapter?.itemCount == expectedItemCount
    }

    override fun describeTo(description: Description?) {
        description?.appendText("ViewPager2 does not contains $expectedItemCount items")
    }

    companion object {
        fun viewPagerHasItemCount(itemCount: Int): Matcher<View> = ViewPagerItemsCountMatcher(itemCount)
    }
}
