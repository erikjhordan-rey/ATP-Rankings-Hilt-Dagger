package io.github.erikjhordanrey.atp_rankings_di.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoDispatcher
import io.github.erikjhordanrey.atp_rankings_di.domain.GetPlayersUseCase
import io.github.erikjhordanrey.atp_rankings_di.domain.Player
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class PlayersViewModel @Inject constructor(private val getPlayersUseCase: GetPlayersUseCase,
                                           private val coDispatcher: CoDispatcher) : ViewModel() {

    private val _playerListState = MutableStateFlow(PlayersUiModel())

    val playerListState: StateFlow<PlayersUiModel>
        get() = _playerListState

    fun loadPlayers() {
        getPlayersUseCase.getAllPlayers()
                .flowOn(coDispatcher.io())
                .catch { it.printStackTrace() }
                .onEach { emitPlayersUiState(it) }
                .launchIn(viewModelScope)
    }

    private fun emitPlayersUiState(players: List<Player>) {
        _playerListState.value = PlayersUiModel(showProgress = false, players)
    }
}
