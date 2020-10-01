package io.github.erikjhordanrey.atp_rankings_di.di.players

import dagger.Module
import dagger.Provides
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoroutineDispatchers
import io.github.erikjhordanrey.atp_rankings_di.core.extension.viewModelProvidersOf
import io.github.erikjhordanrey.atp_rankings_di.domain.GetPlayersUseCase
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersViewModel

@Module
class PlayersUiModule {

    @Provides
    fun providePlayersViewModelFactory(getPlayersUseCase: GetPlayersUseCase, coroutineDispatchers: CoroutineDispatchers) =
            PlayersViewModelFactory(getPlayersUseCase, coroutineDispatchers)

    @Provides
    fun providePlayersViewModel(playersActivity: PlayersActivity, playersViewModelFactory: PlayersViewModelFactory): PlayersViewModel =
            playersActivity.viewModelProvidersOf(playersViewModelFactory)
}
