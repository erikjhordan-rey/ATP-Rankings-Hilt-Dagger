package io.github.erikjhordanrey.atp_rankings_di.domain

import io.github.erikjhordanrey.atp_rankings_di.data.PlayerRepository
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(private val playerRepository: PlayerRepository) {

    suspend fun getAllPlayers() = playerRepository.getAllPlayers()
}
