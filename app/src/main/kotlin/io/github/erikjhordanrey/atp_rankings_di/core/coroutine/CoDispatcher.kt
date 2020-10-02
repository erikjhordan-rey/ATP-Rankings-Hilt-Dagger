package io.github.erikjhordanrey.atp_rankings_di.core.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface CoDispatcher {
    fun io(): CoroutineDispatcher
    fun main(): CoroutineDispatcher
}
