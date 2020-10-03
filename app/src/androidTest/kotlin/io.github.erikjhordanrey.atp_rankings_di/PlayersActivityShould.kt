package io.github.erikjhordanrey.atp_rankings_di

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoDispatcher
import io.github.erikjhordanrey.atp_rankings_di.data.PlayerRepository
import io.github.erikjhordanrey.atp_rankings_di.di.AppModule
import io.github.erikjhordanrey.atp_rankings_di.di.DispatcherModule
import io.github.erikjhordanrey.atp_rankings_di.doubles.TestCoroutineDispatchers
import io.github.erikjhordanrey.atp_rankings_di.doubles.givenPlayers
import io.github.erikjhordanrey.atp_rankings_di.matcher.ViewPagerItemsCountMatcher.Companion.viewPagerHasItemCount
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test

@UninstallModules(AppModule::class, DispatcherModule::class)
@HiltAndroidTest
class PlayersActivityShould {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @BindValue
    @JvmField
    val playerRepository = mockk<PlayerRepository>()

    @ExperimentalCoroutinesApi
    @BindValue
    @JvmField
    val testCoroutineDispatcher: CoDispatcher = TestCoroutineDispatchers()

    @Test
    fun showEmptyViewWhenThereAreNotPlayers() {
        coEvery { playerRepository.getAllPlayers() } returns emptyList()

        launchActivity<PlayersActivity>()

        onView(withId(R.id.empty_players_text_view)).check(matches(isDisplayed()))
    }

    @Test
    fun notShowEmptyViewWhenThereArePlayers() {
        coEvery { playerRepository.getAllPlayers() } returns givenPlayers()

        launchActivity<PlayersActivity>()

        onView(withId(R.id.empty_players_text_view)).check(matches(not(isDisplayed())))
    }

    @Test
    fun notShowProgressBarWhenThereArePlayers() {
        coEvery { playerRepository.getAllPlayers() } returns givenPlayers()

        launchActivity<PlayersActivity>()

        onView(withId(R.id.players_progress_bar)).check(matches(not(isDisplayed())))
    }

    @Test
    fun hasTheNumberOfPlayersOnViewPager() {
        coEvery { playerRepository.getAllPlayers() } returns givenPlayersp

        launchActivity<PlayersActivity>()

        onView(withId(R.id.view_pager)).check(matches(viewPagerHasItemCount(ANY_PLAYER_LIST_COUNT)))
    }

    companion object {

        private const val ANY_PLAYER_LIST_COUNT = 2
    }
}
