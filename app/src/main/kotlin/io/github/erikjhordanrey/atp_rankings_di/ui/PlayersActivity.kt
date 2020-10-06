package io.github.erikjhordanrey.atp_rankings_di.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.erikjhordanrey.atp_rankings_di.R
import io.github.erikjhordanrey.atp_rankings_di.core.extension.compositeScaleTransform
import io.github.erikjhordanrey.atp_rankings_di.core.extension.hideOrShow
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
        liveDataObserve(viewModel.playerListState, { playerListUi(it ?: return@liveDataObserve) })
    }

    private fun playerListUi(playersUiModel: PlayersUiModel) = playersUiModel.run {
        binding.playersProgressBar.hideOrShow(showProgress)
        if (players != null) playerListSuccess(players)
    }

    private fun playerListSuccess(players: List<Player>?) = players?.run {
        if (isNotEmpty()) {
            playersAdapter.set(this)
            binding.viewPager.visible()
            updateTitleIfNeeded(size)
        } else {
            binding.emptyPlayersTextView.visible()
        }
    }

    private fun updateTitleIfNeeded(playerListSize: Int) {
        if (playerListSize > 1) binding.toolbar.title = getString(R.string.top_ranking_text, playerListSize)
    }
}
