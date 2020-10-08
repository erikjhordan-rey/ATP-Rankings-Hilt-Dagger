package io.github.erikjhordanrey.atp_rankings_di.doubles

import io.github.erikjhordanrey.atp_rankings_di.domain.Player

fun givenPlayers(numberPlayers: Int = 1) = mutableListOf<Player>().apply {
    for (i in 0 until numberPlayers) {
        add(givenPlayer(i + 1 ))
    }
}

private fun givenPlayer(i: Int) = Player(
        "$i",
        "Player $i",
        "",
        "")
