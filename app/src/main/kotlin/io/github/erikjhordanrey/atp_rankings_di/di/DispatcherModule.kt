package io.github.erikjhordanrey.atp_rankings_di.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoDispatcher
import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoroutineDispatchers

@Module
@InstallIn(ApplicationComponent::class)
object DispatcherModule {

    @Provides
    fun providesIoDispatcher(): CoDispatcher = CoroutineDispatchers()
}
