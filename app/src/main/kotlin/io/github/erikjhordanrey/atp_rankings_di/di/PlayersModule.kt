package io.github.erikjhordanrey.atp_rankings_di.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.erikjhordanrey.atp_rankings_di.data.PlayerRepository
import io.github.erikjhordanrey.atp_rankings_di.domain.GetPlayersUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
object PlayersModule {

    @Provides
    fun provideGetPlayersUseCase(playersRepository: PlayerRepository) = GetPlayersUseCase(playersRepository)
}
