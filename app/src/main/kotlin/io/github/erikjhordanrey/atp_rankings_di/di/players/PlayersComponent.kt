package io.github.erikjhordanrey.atp_rankings_di.di.players

import dagger.Component
import io.github.erikjhordanrey.atp_rankings_di.di.AppComponent
import io.github.erikjhordanrey.atp_rankings_di.di.scope.FeatureScope
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity

@Component(modules = [PlayersModule::class, PlayersUiModule::class], dependencies = [AppComponent::class])
@FeatureScope
interface PlayersComponent {

    fun inject(playersActivity: PlayersActivity)
}
