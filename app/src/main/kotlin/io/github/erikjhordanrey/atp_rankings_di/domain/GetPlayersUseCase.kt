package io.github.erikjhordanrey.atp_rankings_di.domain

import io.github.erikjhordanrey.atp_rankings_di.data.Repository

class GetPlayersUseCase(private val repository: Repository) {

    suspend fun getAllPlayers() = repository.getAllPlayers()
}
