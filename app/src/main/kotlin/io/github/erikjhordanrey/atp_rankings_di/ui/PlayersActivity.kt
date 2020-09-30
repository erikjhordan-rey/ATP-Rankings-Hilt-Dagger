package io.github.erikjhordanrey.atp_rankings_di.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import io.github.erikjhordanrey.atp_rankings_di.common.ui.ViewPager2PageTransformation
import io.github.erikjhordanrey.atp_rankings_di.common.ui.liveDataObserve
import io.github.erikjhordanrey.atp_rankings_di.databinding.ActivityPlayersBinding
import io.github.erikjhordanrey.atp_rankings_di.di.players.inject
import javax.inject.Inject

class PlayersActivity : AppCompatActivity() {

    // @Inject lateinit var viewModelFactory: ViewModelFactory

    private val playersAdapter by lazy { PlayersAdapter() }

    private lateinit var binding: ActivityPlayersBinding

    @Inject
    lateinit var viewModel: PlayersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inject(this)
        //viewModel = viewModelProvidersOf(viewModelFactory)
        binding.viewPager.adapter = playersAdapter
      //  binding.viewPager.setPageTransformer(ViewPager2PageTransformation())
        val marginPageTransformer = MarginPageTransformer(50)

        binding.viewPager.setPageTransformer(CompositePageTransformer().also {
            it.addTransformer(marginPageTransformer)
            it.addTransformer(ViewPager2PageTransformation())
        })

        viewModel.loadPlayers()
        liveDataObserve(viewModel.playerListState, { players ->
            players?.run { playersAdapter.set(players) }

        })

    }

}


