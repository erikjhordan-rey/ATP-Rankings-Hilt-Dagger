package io.github.erikjhordanrey.atp_rankings_di

import io.github.erikjhordanrey.atp_rankings_di.data.Repository
import io.github.erikjhordanrey.atp_rankings_di.domain.Player

class FakePlayerRepository : Repository {

    override suspend fun getAllPlayers() = mutableListOf<Player>().apply {
        add(fakePlayer())
    }

    private fun fakePlayer() = Player(
            "1",
            "Tennis Player 1",
            "https://www.atptour.com/-/media/tennis/players/gladiator/2019/djokovic_full_ao19.png",
            "https://www.atptour.com/-/media/tennis/players/profile-hero/heritage-player/no1-playerbg_2019_djokovic.jpg")
}
