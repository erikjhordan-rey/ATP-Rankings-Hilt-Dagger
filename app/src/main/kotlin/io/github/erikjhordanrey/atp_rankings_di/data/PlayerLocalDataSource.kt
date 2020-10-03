package io.github.erikjhordanrey.atp_rankings_di.data

import io.github.erikjhordanrey.atp_rankings_di.core.testing.OpenForTesting
import io.github.erikjhordanrey.atp_rankings_di.domain.Player
import kotlinx.coroutines.delay

@OpenForTesting
class PlayerLocalDataSource {

    suspend fun getAllPlayers(): List<Player> {
        delay(1500)
        return createPlayers()
    }

    private fun createPlayers() = mutableListOf<Player>().apply {
        add(player1())
        add(player2())
        add(player3())
        add(player4())
        add(player5())
        add(player6())
        add(player7())
        add(player8())
        add(player9())
        add(player10())
    }

    private fun player1() = Player(
        "1",
        "Novak Djokovic",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2019/djokovic_full_ao19.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/heritage-player/no1-playerbg_2019_djokovic.jpg"
    )

    private fun player2() = Player(
        "2",
        "Rafael Nadal",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/nadal_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/heritage-player/no1-playerbg_2020_nadal.jpg"
    )

    private fun player3() = Player(
        "3",
        "Dominic Thiem",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/thiem_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/by-country/aut.jpg"
    )

    private fun player4() = Player(
        "4",
        "Roger Federer",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/federer_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/heritage-player/federer-no1-playerbg_2019.jpg"
    )

    private fun player5() = Player(
        "5",
        "Daniil Medvedev",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/medvedev_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/by-country/rus.jpg"
    )

    private fun player6() = Player(
        "6",
        "Stefanos Tsitsipas",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/tsitsipas_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/winners-playerbg_tsitsipas.jpg"
    )

    private fun player7() = Player(
        "7",
        "Alexander Zverev",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/zverev_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/winners-playerbg_zverev.jpg"
    )

    private fun player8() = Player(
        "8",
        "Matteo Berrettini",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/berrettini_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/by-country/ita.jpg"
    )

    private fun player9() = Player(
        "9",
        "Gael Monfils",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/monfils_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/by-country/fra.jpg"
    )

    private fun player10() = Player(
        "10",
        "Roberto Bautista",
        "https://www.atptour.com/-/media/tennis/players/gladiator/2020/bautista_agut_full_ao20.png",
        "https://www.atptour.com/-/media/tennis/players/profile-hero/by-country/esp.jpg"
    )
}
