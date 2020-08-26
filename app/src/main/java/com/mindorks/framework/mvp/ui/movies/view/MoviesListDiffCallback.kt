package com.mindorks.framework.mvp.ui.genre.view

import androidx.recyclerview.widget.DiffUtil
import com.mindorks.framework.mvp.data.models.Genres
import com.mindorks.framework.mvp.data.models.Movie

class MoviesListDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }
}