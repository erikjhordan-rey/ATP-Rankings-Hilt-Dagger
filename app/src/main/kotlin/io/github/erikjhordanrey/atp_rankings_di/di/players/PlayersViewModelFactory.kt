package io.github.erikjhordanrey.atp_rankings_di.di.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.erikjhordanrey.atp_rankings_di.common.CoroutineDispatchers
import io.github.erikjhordanrey.atp_rankings_di.domain.GetPlayersUseCase
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersViewModel

class PlayersViewModelFactory(private val getPlayersUseCase: GetPlayersUseCase, private val coroutineDispatchers: CoroutineDispatchers) :
        ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            if (modelClass.isAssignableFrom(PlayersViewModel::class.java)) PlayersViewModel(getPlayersUseCase, coroutineDispatchers) as T
            else throw IllegalArgumentException("Unknown ViewModel class")
}
