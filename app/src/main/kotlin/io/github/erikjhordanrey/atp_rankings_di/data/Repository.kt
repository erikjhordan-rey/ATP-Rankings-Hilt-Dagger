package io.github.erikjhordanrey.atp_rankings_di.data

import io.github.erikjhordanrey.atp_rankings_di.domain.Player

interface Repository {

    suspend fun getAllPlayers(): List<Player>
}
