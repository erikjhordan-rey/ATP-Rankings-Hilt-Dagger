package io.github.erikjhordanrey.atp_rankings_di.doubles

import io.github.erikjhordanrey.atp_rankings_di.core.coroutine.CoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

class TestCoroutineDispatchers : CoDispatcher {

    @ExperimentalCoroutinesApi
    override fun io(): CoroutineDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    override fun main(): CoroutineDispatcher = TestCoroutineDispatcher()
}
