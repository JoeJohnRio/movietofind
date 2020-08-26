package com.mindorks.framework.mvp.ui.genre.view

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.Genres
import com.mindorks.framework.mvp.ui.login.view.GenreActivity
import com.mindorks.framework.mvp.ui.login.view.MoviesActivity
import kotlinx.android.extensions.LayoutContainer

class GenreViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

    private var tvGenreName: TextView? = null

    init {
        tvGenreName = itemView.findViewById(R.id.tv_genre_name)
    }

    fun bind(
            view: GenreActivity,
            response: Genres
    ) {
        tvGenreName?.setText(response.name ?: "")

        itemView.setOnClickListener {
            view.showMessageToast(response.name ?: "Error")
            val intent = Intent(itemView.context, MoviesActivity::class.java)
            intent.putExtra(
                    "tvMovieId",
                    response.id
            )
            intent.putExtra(
                    "genreName",
                    response.name
            )
            itemView.context.startActivity(intent)
        }
    }
}