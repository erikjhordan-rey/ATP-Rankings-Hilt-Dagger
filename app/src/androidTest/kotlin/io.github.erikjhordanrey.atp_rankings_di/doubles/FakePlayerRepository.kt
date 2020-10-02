package io.github.erikjhordanrey.atp_rankings_di.doubles

import io.github.erikjhordanrey.atp_rankings_di.data.Repository
import io.github.erikjhordanrey.atp_rankings_di.domain.Player

class FakePlayerRepository : Repository {

    override suspend fun getAllPlayers() = givenPlayers()
}

private fun givenPlayers() = mutableListOf<Player>().apply {
    add(givenPlayer())
    add(givenPlayer2())
}

private fun givenPlayer() = Player(
        "1",
        "Player 1",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2019/djokovic_full_ao19.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/heritage-player/no1-playerbg_2019_djokovic.jpg")

private fun givenPlayer2() = Player(
        "2",
        "Player 2",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/nadal_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/heritage-player/no1-playerbg_2020_nadal.jpg")
