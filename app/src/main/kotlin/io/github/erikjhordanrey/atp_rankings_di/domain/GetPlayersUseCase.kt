package io.github.erikjhordanrey.atp_rankings_di.domain

import io.github.erikjhordanrey.atp_rankings_di.data.PlayerRepository

class GetPlayersUseCase(private val playerRepository: PlayerRepository) {

    fun getAllPlayers() = playerRepository.getAllPlayers()
}
