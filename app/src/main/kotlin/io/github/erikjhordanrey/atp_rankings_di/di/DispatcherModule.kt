package io.github.erikjhordanrey.atp_rankings_di.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoDispatcher
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoroutineDispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    fun providesIoDispatcher(): CoDispatcher = CoroutineDispatchers()
}
