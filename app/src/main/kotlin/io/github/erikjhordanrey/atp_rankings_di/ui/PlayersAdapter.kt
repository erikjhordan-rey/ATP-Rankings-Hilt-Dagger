package io.github.erikjhordanrey.atp_rankings_di.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.erikjhordanrey.atp_rankings_di.databinding.ItemPlayerBinding
import io.github.erikjhordanrey.atp_rankings_di.domain.Player

class PlayersAdapter : RecyclerView.Adapter<PlayersViewHolder>() {

    private val itemList: MutableList<Player> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            PlayersViewHolder(ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size

    fun set(items: List<Player>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }
}
