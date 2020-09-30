package io.github.erikjhordanrey.atp_rankings_di.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PlayersViewModel::class)
    abstract fun bindPlayersViewModel(playersViewModel: PlayersViewModel): ViewModel
}

