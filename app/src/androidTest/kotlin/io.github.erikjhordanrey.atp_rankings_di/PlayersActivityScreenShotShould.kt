package io.github.erikjhordanrey.atp_rankings_di

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
import io.github.erikjhordanrey.atp_rankings_di.screenshot.ScreenShotShould
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@UninstallModules(AppModule::class, DispatcherModule::class)
@HiltAndroidTest
class PlayersActivityScreenShotShould : ScreenShotShould<PlayersActivity>(PlayersActivity::class.java) {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<PlayersActivity>()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

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

        val scenario = startActivity()

        compareScreenshot(scenario)
    }

    @Test
    fun notShowEmptyViewWhenThereArePlayers() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(givenPlayers()) }

        val scenario = startActivity()

        compareScreenshot(scenario)
    }

    @Test
    fun showPlayersSizeInToolbarWhenThereAreMorePlayers() {
        playerRepository.stub { onBlocking { getAllPlayers() }.doReturn(givenPlayers(4)) }

        val scenario = startActivity()

        compareScreenshot(scenario)
    }
}
