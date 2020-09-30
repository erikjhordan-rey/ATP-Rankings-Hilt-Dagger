package io.github.erikjhordanrey.atp_rankings_di.domain

import androidx.annotation.WorkerThread
import io.github.erikjhordanrey.atp_rankings_di.data.PlayerRepository
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(private val playerRepository: PlayerRepository) {

    @WorkerThread
    suspend fun getAllPlayers() = playerRepository.getAllPlayers()
}
