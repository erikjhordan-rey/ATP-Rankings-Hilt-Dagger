package io.github.erikjhordanrey.atp_rankings_di

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.stub
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
import io.github.erikjhordanrey.atp_rankings_di.screenshot.ScreenShotShould
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test

@UninstallModules(AppModule::class, DispatcherModule::class)
@HiltAndroidTest
class PlayersActivityShould : ScreenShotShould<PlayersActivity>(PlayersActivity::class.java) {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityScenarioRule = activityScenarioRule<PlayersActivity>()

    @BindValue
    @JvmField
    val playerRepository: PlayerRepository = mock()

    @ExperimentalCoroutinesApi
    @BindValue
    @JvmField
    val testCoroutineDispatcher: CoDispatcher = TestCoroutineDispatchers()

    @Test
    fun showEmptyViewWhenThereAreNotPlayers() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(emptyList()) }

        launchActivity<PlayersActivity>()

        onView(withId(R.id.empty_players_text_view)).check(matches(isDisplayed()))
    }

    @Test
    fun notShowEmptyViewWhenThereArePlayers() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(givenPlayers()) }

        launchActivity<PlayersActivity>()

        onView(withId(R.id.empty_players_text_view)).check(matches(not(isDisplayed())))
    }

    @Test
    fun notShowProgressBarWhenThereArePlayers() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(givenPlayers()) }

        launchActivity<PlayersActivity>()

        onView(withId(R.id.players_progress_bar)).check(matches(not(isDisplayed())))
    }

    @Test
    fun hasTheNumberOfPlayersOnViewPager() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(givenPlayers(4)) }

        launchActivity<PlayersActivity>()

        onView(withId(R.id.view_pager)).check(matches(viewPagerHasItemCount(ANY_PLAYER_LIST_COUNT)))
    }

    @Test
    fun showEmptyViewWhenThereAreNotPlayersScreenShot() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(emptyList()) }

        val scenario = startActivity()

        compareScreenshot(scenario)
    }

    @Test
    fun notShowEmptyViewWhenThereArePlayersScreenShot() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(givenPlayers()) }

        val scenario = startActivity()

        compareScreenshot(scenario)
    }

    @Test
    fun showPlayersSizeInToolbarWhenThereAreMorePlayersScreenShot() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(givenPlayers(4)) }

        val scenario = startActivity()

        compareScreenshot(scenario)
    }

    companion object {

        private const val ANY_PLAYER_LIST_COUNT = 4
    }
}
