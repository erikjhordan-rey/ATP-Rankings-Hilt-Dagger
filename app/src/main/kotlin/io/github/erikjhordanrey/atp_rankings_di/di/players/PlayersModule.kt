package io.github.erikjhordanrey.atp_rankings_di.di.players

import dagger.Module
import dagger.Provides
import io.github.erikjhordanrey.atp_rankings_di.data.PlayerLocalDataSource
import io.github.erikjhordanrey.atp_rankings_di.data.PlayerRepository
import io.github.erikjhordanrey.atp_rankings_di.di.scope.FeatureScope

@Module
object PlayersModule {

    @Provides
    @FeatureScope
    fun providePlayerLocalDataSource() = PlayerLocalDataSource()

    @Provides
    @FeatureScope
    fun providePlayerRepository(playerLocalDataSource: PlayerLocalDataSource) = PlayerRepository(playerLocalDataSource)
}
