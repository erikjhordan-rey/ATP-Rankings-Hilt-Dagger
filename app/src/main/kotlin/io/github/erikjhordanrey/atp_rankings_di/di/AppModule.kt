package io.github.erikjhordanrey.atp_rankings_di.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.github.erikjhordanrey.atp_rankings_di.data.PlayerLocalDataSource
import io.github.erikjhordanrey.atp_rankings_di.data.PlayerRepository

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun providePlayerLocalDataSource() = PlayerLocalDataSource()

    @Provides
    fun providePlayerRepository(playerLocalDataSource: PlayerLocalDataSource) = PlayerRepository(playerLocalDataSource)
}
