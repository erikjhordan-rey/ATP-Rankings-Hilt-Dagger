package io.github.erikjhordanrey.atp_rankings_di.data

import io.github.erikjhordanrey.atp_rankings_di.domain.Player

class PlayerRepository(private val playerLocalDataSource: PlayerLocalDataSource) : Repository {

    override suspend fun getAllPlayers() = playerLocalDataSource.getAllPlayers()
}

interface Repository {
    suspend fun getAllPlayers(): List<Player>
}
