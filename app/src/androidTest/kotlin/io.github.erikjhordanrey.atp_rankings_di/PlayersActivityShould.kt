package io.github.erikjhordanrey.atp_rankings_di

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.github.erikjhordanrey.atp_rankings_di.matcher.ViewPagerItemsCountMatcher.Companion.viewPagerHasItemCount
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoDispatcher
import io.github.erikjhordanrey.atp_rankings_di.data.Repository
import io.github.erikjhordanrey.atp_rankings_di.di.AppModule
import io.github.erikjhordanrey.atp_rankings_di.di.DispatcherModule
import io.github.erikjhordanrey.atp_rankings_di.doubles.FakePlayerRepository
import io.github.erikjhordanrey.atp_rankings_di.doubles.TestCoroutineDispatchers
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@UninstallModules(AppModule::class, DispatcherModule::class)
@HiltAndroidTest
class PlayersActivityShould {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @BindValue
    @JvmField
    val fakePlayerRepository: Repository = FakePlayerRepository()

    @ExperimentalCoroutinesApi
    @BindValue
    @JvmField
    val testCoroutineDispatcher: CoDispatcher = TestCoroutineDispatchers()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun displayTheNumberOfPlayers() {
        launchActivity<PlayersActivity>()

        onView(withId(R.id.view_pager)).check(matches(viewPagerHasItemCount(ANY_PLAYER_LIST_COUNT)))
    }

    companion object {

        private const val ANY_PLAYER_LIST_COUNT = 2
    }
}
