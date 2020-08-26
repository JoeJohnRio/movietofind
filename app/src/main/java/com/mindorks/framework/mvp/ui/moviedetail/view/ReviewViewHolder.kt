package com.mindorks.framework.mvp.ui.genre.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.Movie
import com.mindorks.framework.mvp.data.models.Review
import com.mindorks.framework.mvp.ui.login.view.MovieDetailActivity
import com.mindorks.framework.mvp.util.AppConstants
import com.mindorks.framework.mvp.util.extension.loadImage
import kotlinx.android.extensions.LayoutContainer

class ReviewViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

    private var url: String = "https://tanzolymp.com/images/default-non-user-no-photo-1-300x300.jpg"

    private var tvReviewerName: TextView? = null
    private var tvReview: TextView? = null

    init {
        tvReviewerName = itemView.findViewById(R.id.tv_reviewer_name)
        tvReview= itemView.findViewById(R.id.tv_review)
//        tvMovieDesc= itemView.findViewById(R.id.tv_movie_desc)
//        ivMoviesPoster = itemView.findViewById(R.id.iv_image_film)
    }

    fun bind(
            view: MovieDetailActivity,
            response: Review
    ) {
        tvReviewerName?.text = "${response.author}"
        tvReview?.text = "${response.content}"

//        itemView.setOnClickListener {
//            view.showMessageToast(response.originalTitle ?: "Error")
//            val intent = Intent(itemView.context, ProfileActivity::class.java)
//            intent.putExtra(
//                    "MAHASISWA_ID",
//                    response.id
//            )
//            itemView.context.startActivity(intent)
//        }
    }
}