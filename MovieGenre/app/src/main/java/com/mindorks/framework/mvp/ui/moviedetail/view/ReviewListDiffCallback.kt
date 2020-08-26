package com.mindorks.framework.mvp.ui.genre.view

import androidx.recyclerview.widget.DiffUtil
import com.mindorks.framework.mvp.data.models.Genres
import com.mindorks.framework.mvp.data.models.Movie
import com.mindorks.framework.mvp.data.models.Review

class ReviewListDiffCallback : DiffUtil.ItemCallback<Review>() {
    override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
        return oldItem.id == newItem.id
    }
}