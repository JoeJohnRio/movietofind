package com.mindorks.framework.mvp.ui.genre.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.Genres
import com.mindorks.framework.mvp.data.models.Movie
import com.mindorks.framework.mvp.data.models.Review
import com.mindorks.framework.mvp.ui.login.view.MovieDetailActivity
import com.mindorks.framework.mvp.ui.login.view.MoviesActivity

class ReviewListAdapter(var view: MovieDetailActivity) :
        ListAdapter<Review, RecyclerView.ViewHolder>(ReviewListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder  {
        return ReviewViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_reviews,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val response = getItem(position) as Review

        holder as ReviewViewHolder
        holder.bind(view, response)
    }
}