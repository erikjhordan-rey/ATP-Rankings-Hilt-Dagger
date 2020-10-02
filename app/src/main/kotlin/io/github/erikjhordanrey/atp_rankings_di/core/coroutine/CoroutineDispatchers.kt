package io.github.erikjhordanrey.atp_rankings_di.core.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class CoroutineDispatchers : CoDispatcher {

    override fun io(): CoroutineDispatcher = IO

    override fun main(): CoroutineDispatcher = Main
}
