package io.github.erikjhordanrey.atp_rankings_di.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.erikjhordanrey.atp_rankings_di.core.extension.compositeScaleTransform
import io.github.erikjhordanrey.atp_rankings_di.core.extension.hide
import io.github.erikjhordanrey.atp_rankings_di.core.extension.liveDataObserve
import io.github.erikjhordanrey.atp_rankings_di.core.extension.visible
import io.github.erikjhordanrey.atp_rankings_di.databinding.ActivityPlayersBinding
import io.github.erikjhordanrey.atp_rankings_di.domain.Player

@AndroidEntryPoint
class PlayersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayersBinding

    private val playersAdapter by lazy { PlayersAdapter() }

    private val viewModel by viewModels<PlayersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        initUi()
        viewModel.loadPlayers()
    }

    private fun initUi() = binding.viewPager.run {
        adapter = playersAdapter
        compositeScaleTransform()
    }

    private fun initObservers() {
        liveDataObserve(viewModel.playerListState, { playerListStateUi(it ?: return@liveDataObserve) })
    }

    private fun playerListStateUi(players: List<Player>) {
        if (players.isNotEmpty()) {
            playersAdapter.set(players)
            binding.viewPager.visible()
        }
    }
}
