package io.github.erikjhordanrey.atp_rankings_di.data

open class PlayerRepository(private val playerLocalDataSource: PlayerLocalDataSource) : Repository {

    override suspend fun getAllPlayers() = playerLocalDataSource.getAllPlayers()
}
