package io.github.erikjhordanrey.atp_rankings_di.di.players

import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoroutineDispatchers
import io.github.erikjhordanrey.atp_rankings_di.core.extension.viewModelProvidersOf
import io.github.erikjhordanrey.atp_rankings_di.domain.GetPlayersUseCase
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersViewModel


class PlayersUiModule(private val playersActivity: PlayersActivity) {

    //@Provides
    fun providePlayersViewModelFactory(getPlayersUseCase: GetPlayersUseCase, coroutineDispatchers: CoroutineDispatchers) =
            PlayersViewModelFactory(getPlayersUseCase, coroutineDispatchers)

    //@Provides
    fun providePlayersViewModel(playersViewModelFactory: PlayersViewModelFactory): PlayersViewModel =
            playersActivity.viewModelProvidersOf(playersViewModelFactory)
}
