package com.mindorks.framework.mvp.ui.genre.view

import androidx.recyclerview.widget.DiffUtil
import com.mindorks.framework.mvp.data.models.Genres

class GenreListDiffCallback : DiffUtil.ItemCallback<Genres>() {
    override fun areItemsTheSame(oldItem: Genres, newItem: Genres): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Genres, newItem: Genres): Boolean {
        return oldItem.id == newItem.id
    }
}