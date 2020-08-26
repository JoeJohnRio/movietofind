package com.mindorks.framework.mvp.ui.genre.view

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.Movie
import com.mindorks.framework.mvp.ui.login.view.MovieDetailActivity
import com.mindorks.framework.mvp.ui.login.view.MoviesActivity
import com.mindorks.framework.mvp.util.AppConstants
import com.mindorks.framework.mvp.util.extension.loadImage
import kotlinx.android.extensions.LayoutContainer

class MoviesViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

    private var url: String = "https://tanzolymp.com/images/default-non-user-no-photo-1-300x300.jpg"

    private var tvMovieTitle: TextView? = null
    private var tvMovieRating: TextView? = null
    private var tvMovieDesc: TextView? = null
    private var ivMoviesPoster: ImageView? = null

    init {
        tvMovieTitle = itemView.findViewById(R.id.tv_movie_title_name)
        tvMovieRating= itemView.findViewById(R.id.tv_movie_rating)
        tvMovieDesc= itemView.findViewById(R.id.tv_movie_desc)
        ivMoviesPoster = itemView.findViewById(R.id.iv_image_film)
    }

    fun bind(
            view: MoviesActivity,
            response: Movie
    ) {
        tvMovieTitle?.text = "${response.originalTitle} - ${response.releaseDate?.substring(0,4)}"
        tvMovieRating?.text = "${response.voteAverage} out of 10"
        tvMovieDesc?.text = response.overView

        ivMoviesPoster?.loadImage(AppConstants.IMAGE + response.posterPath)

        itemView.setOnClickListener {
            view.showMessageToast(response.originalTitle ?: "Error")
            val intent = Intent(itemView.context, MovieDetailActivity::class.java)
            intent.putExtra("tvMovieTitle", response.originalTitle)
            intent.putExtra("ivImageUrl", response.posterPath)
            intent.putExtra("tvMovieDesc", response.overView)
            intent.putExtra("tvMovieId", response.id)
            itemView.context.startActivity(intent)
        }
    }
}