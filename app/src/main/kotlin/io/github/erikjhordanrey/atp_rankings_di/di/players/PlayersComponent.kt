package io.github.erikjhordanrey.atp_rankings_di.di.players

import dagger.BindsInstance
import dagger.Component
import io.github.erikjhordanrey.atp_rankings_di.di.AppComponent
import io.github.erikjhordanrey.atp_rankings_di.di.scope.FeatureScope
import io.github.erikjhordanrey.atp_rankings_di.ui.PlayersActivity

@Component(modules = [PlayersModule::class, PlayersUiModule::class], dependencies = [AppComponent::class])
@FeatureScope
interface PlayersComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun playersActivity(playersActivity: PlayersActivity): Builder

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): PlayersComponent
    }

    fun inject(playersActivity: PlayersActivity)
}
