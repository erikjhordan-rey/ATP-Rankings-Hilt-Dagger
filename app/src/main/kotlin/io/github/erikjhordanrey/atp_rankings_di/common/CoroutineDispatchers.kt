package io.github.erikjhordanrey.atp_rankings_di.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

data class CoroutineDispatchers(val main: CoroutineDispatcher, val io: CoroutineDispatcher) {
    @Inject
    constructor() : this(Main, IO)
}
