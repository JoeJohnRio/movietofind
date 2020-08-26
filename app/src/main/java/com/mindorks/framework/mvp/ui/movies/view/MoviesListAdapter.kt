package com.mindorks.framework.mvp.ui.genre.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.Genres
import com.mindorks.framework.mvp.data.models.Movie
import com.mindorks.framework.mvp.ui.login.view.MoviesActivity

class MoviesListAdapter(var view: MoviesActivity) :
        ListAdapter<Movie, RecyclerView.ViewHolder>(MoviesListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder  {
        return MoviesViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_movie,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val response = getItem(position) as Movie
        holder as MoviesViewHolder
        holder.bind(view, response)
    }
}