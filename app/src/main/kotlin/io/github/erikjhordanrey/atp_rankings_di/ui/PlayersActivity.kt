package io.github.erikjhordanrey.atp_rankings_di.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.erikjhordanrey.atp_rankings_di.core.extension.compositeScaleTransform
import io.github.erikjhordanrey.atp_rankings_di.core.extension.liveDataObserve
import io.github.erikjhordanrey.atp_rankings_di.core.extension.viewModelProvidersOf
import io.github.erikjhordanrey.atp_rankings_di.databinding.ActivityPlayersBinding
import io.github.erikjhordanrey.atp_rankings_di.di.players.PlayersViewModelFactory
import io.github.erikjhordanrey.atp_rankings_di.di.players.inject
import io.github.erikjhordanrey.atp_rankings_di.domain.Player
import javax.inject.Inject

class PlayersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayersBinding

    private val playersAdapter by lazy { PlayersAdapter() }

    @Inject
    lateinit var playersViewModelFactory: PlayersViewModelFactory

    lateinit var viewModel: PlayersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inject(this)
        viewModel = viewModelProvidersOf(playersViewModelFactory)
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
        playersAdapter.set(players)
    }
}
