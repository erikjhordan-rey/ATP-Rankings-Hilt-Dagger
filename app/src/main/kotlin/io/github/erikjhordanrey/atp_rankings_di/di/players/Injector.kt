package io.github.erikjhordanrey.atp_rankings_di.di.players

import io.github.erikjhordanrey.atp_rankings_di.di.appComponent
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity

fun inject(playersActivity: PlayersActivity) = playersActivity.run {
    DaggerPlayersComponent.builder()
        .appComponent(appComponent())
        .build()
        .inject(this)
}
