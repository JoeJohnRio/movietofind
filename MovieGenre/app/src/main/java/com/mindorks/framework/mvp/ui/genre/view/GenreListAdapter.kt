package com.mindorks.framework.mvp.ui.genre.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.Genres
import com.mindorks.framework.mvp.ui.login.view.GenreActivity

class GenreListAdapter(var view: GenreActivity) :
        ListAdapter<Genres, RecyclerView.ViewHolder>(GenreListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder  {
        return GenreViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_genre,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val response = getItem(position) as Genres
        holder as GenreViewHolder
        holder.bind(view, response)
    }
}