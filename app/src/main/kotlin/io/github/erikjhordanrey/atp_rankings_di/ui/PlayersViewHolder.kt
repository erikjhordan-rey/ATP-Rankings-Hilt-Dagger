package io.github.erikjhordanrey.atp_rankings_di.ui

import androidx.recyclerview.widget.RecyclerView
import io.github.erikjhordanrey.atp_rankings_di.common.ui.setUrl
import io.github.erikjhordanrey.atp_rankings_di.databinding.ItemPlayerBinding
import io.github.erikjhordanrey.atp_rankings_di.domain.Player

class PlayersViewHolder(private val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) = player.run {
        binding.playerImage.setUrl(image)
        binding.playerFlagImage.setUrl(flag)
        binding.playerRankingTextView.text = ranking
        binding.playerNameTextView.text = name
    }
}
