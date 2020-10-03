package io.github.erikjhordanrey.atp_rankings_di.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoDispatcher
import io.github.erikjhordanrey.atp_rankings_di.domain.GetPlayersUseCase
import io.github.erikjhordanrey.atp_rankings_di.domain.Player
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayersViewModel @ViewModelInject constructor(private val getPlayersUseCase: GetPlayersUseCase,
                                                    private val coDispatcher: CoDispatcher) : ViewModel() {

    private val _playerListState = MutableLiveData<PlayersUiModel>()

    val playerListState: LiveData<PlayersUiModel>
        get() = _playerListState

    fun loadPlayers() {
        emitPlayersUiState(showProgress = true)
        viewModelScope.launch(coDispatcher.io()) {
            val result = getPlayersUseCase.getAllPlayers()
            withContext(coDispatcher.main()) { loadPlayersSuccess(result) }
        }
    }

    private fun loadPlayersSuccess(players: List<Player>?) {
        emitPlayersUiState(players = players)
    }

    private fun emitPlayersUiState(showProgress: Boolean = false, players: List<Player>? = null) {
        _playerListState.value = PlayersUiModel(showProgress, players)
    }
}
