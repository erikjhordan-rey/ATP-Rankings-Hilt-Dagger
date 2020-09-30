package io.github.erikjhordanrey.atp_rankings_di.data

class PlayerRepository(private val playerLocalDataSource: PlayerLocalDataSource) {

    suspend fun getAllPlayers() = playerLocalDataSource.getAllPlayers()
}
