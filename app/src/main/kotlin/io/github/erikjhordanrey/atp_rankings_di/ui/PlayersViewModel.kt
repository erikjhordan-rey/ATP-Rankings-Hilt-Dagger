package io.github.erikjhordanrey.atp_rankings_di.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoroutineDispatchers
import io.github.erikjhordanrey.atp_rankings_di.domain.GetPlayersUseCase
import io.github.erikjhordanrey.atp_rankings_di.domain.Player
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayersViewModel @ViewModelInject constructor(private val getPlayersUseCase: GetPlayersUseCase,
                                                    private val coroutineDispatchers: CoroutineDispatchers) : ViewModel() {

    private val _playerListState = MutableLiveData<List<Player>>()

    val playerListState: LiveData<List<Player>>
        get() = _playerListState

    fun loadPlayers() {
        viewModelScope.launch(coroutineDispatchers.io) {
            val result = getPlayersUseCase.getAllPlayers()
            withContext(coroutineDispatchers.main) { _playerListState.value = result }
        }
    }
}
