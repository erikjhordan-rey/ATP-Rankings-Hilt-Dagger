package io.github.erikjhordanrey.atp_rankings_di.di.players

import dagger.Module
import dagger.Provides
import io.github.erikjhordanrey.atp_rankings_di.core.extension.viewModelProvidersOf
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersViewModel

@Module
class PlayersUiModule(private val playersActivity: PlayersActivity) {

    @Provides
    fun providePlayersViewModel(playersViewModelFactory: PlayersViewModelFactory): PlayersViewModel =
            playersActivity.viewModelProvidersOf(playersViewModelFactory)
}
