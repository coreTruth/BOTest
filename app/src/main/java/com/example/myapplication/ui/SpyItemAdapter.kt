package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemBinding
import com.example.myapplication.entity.SpyItem

class SpyItemAdapter(): ListAdapter<SpyItem, SpyItemAdapter.ItemViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(getItem(position))

    class ItemViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SpyItem) =
            with(binding) {
                tvHint.text = item.hint
                tvAuthorHint.text = item.author
                tvDistance.text = String.format("%s ft", item.distance.toString())
                tvRating.text = String.format("%s Rating", item.rating.toString())
                tvScore.text = String.format("%s Wins", item.score.toString())
            }
    }

    private class DiffCallback : DiffUtil.ItemCallback<SpyItem>() {
        override fun areItemsTheSame(oldItem: SpyItem, newItem: SpyItem) =
            oldItem.author == newItem.author

        override fun areContentsTheSame(oldItem: SpyItem, newItem: SpyItem) =
            oldItem == newItem
    }
}
