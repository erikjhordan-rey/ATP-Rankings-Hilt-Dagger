package io.github.erikjhordanrey.atp_rankings_di.data

import io.github.erikjhordanrey.atp_rankings_di.core.testing.OpenForTesting
import kotlinx.coroutines.flow.distinctUntilChanged

@OpenForTesting
class PlayerRepository(private val playerLocalDataSource: PlayerLocalDataSource) {

    fun getAllPlayers() = playerLocalDataSource.getAllPlayers().distinctUntilChanged()
}

