package io.github.erikjhordanrey.atp_rankings_di.ui

import io.github.erikjhordanrey.atp_rankings_di.domain.Player

data class PlayersUiModel(val showProgress: Boolean = true, val players: List<Player>? = null)
