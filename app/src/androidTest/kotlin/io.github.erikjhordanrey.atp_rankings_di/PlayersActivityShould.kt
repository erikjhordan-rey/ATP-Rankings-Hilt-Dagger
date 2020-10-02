package io.github.erikjhordanrey.atp_rankings_di

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.github.erikjhordanrey.atp_rankings_di.ViewPagerItemsCountMatcher.Companion.viewPagerHasItemCount
import io.github.erikjhordanrey.atp_rankings_di.data.Repository
import io.github.erikjhordanrey.atp_rankings_di.di.AppModule
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@UninstallModules(AppModule::class)
@HiltAndroidTest
class PlayersActivityShould {

    @BindValue
    @JvmField
    val playerRepository: Repository = FakePlayerRepository()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun displayTheNumberOfPlayers() {
        launchActivity<PlayersActivity>()

        onView(withId(R.id.view_pager)).check(matches(viewPagerHasItemCount(4)))
    }

}


