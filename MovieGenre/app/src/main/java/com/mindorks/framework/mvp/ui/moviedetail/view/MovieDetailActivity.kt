package com.mindorks.framework.mvp.ui.login.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.*
import com.mindorks.framework.mvp.databinding.ActivityMovieDetailBinding
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.genre.view.MoviesListAdapter
import com.mindorks.framework.mvp.ui.genre.view.ReviewListAdapter
import com.mindorks.framework.mvp.ui.login.presenter.MovieDetailPresenter
import com.mindorks.framework.mvp.util.AppConstants
import com.mindorks.framework.mvp.util.extension.loadImage
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class MovieDetailActivity : BaseActivity(), MovieDetailMVPView {
    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    internal lateinit var presenter: MovieDetailPresenter<MovieDetailMVPView>
    lateinit var viewBind: ActivityMovieDetailBinding
    lateinit var listAdapter: ReviewListAdapter
    var listMovies: MutableList<Review> = mutableListOf()
    var tvMovieId = 0
    var pageNumber = 1
    var lastPage = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        presenter.onAttach(this)
        tvMovieId = intent.getIntExtra("tvMovieId", 0)
        viewBind.tvMovieDetailTitle.text = intent.getStringExtra("tvMovieTitle")
        viewBind.tvMovieDetailDesc.text = intent.getStringExtra("tvMovieDesc")

        listAdapter = ReviewListAdapter(this)
        listAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT
        presenter.getReviews(tvMovieId, pageNumber, true)
        presenter.getYoutubeKey(tvMovieId)
        viewBind.rvMoviesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    if (lastPage >= pageNumber) {
                        Log.d("onScrolled", "Sedang scroll")
                        pageNumber++
                        presenter.getReviews(tvMovieId, pageNumber, false)
                    }
                }
            }
        })
    }

    override fun setYoutubeKeys(youtubeKeys: YoutubeKeys) {
        if (!youtubeKeys.results.isNullOrEmpty()){
            viewBind.aypImageDetailFilm.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(youtubeKeys.results!!.get(0).key.toString(), 0F)
                }
            })
        }
    }

    override fun setReviews(reviews: Reviews, isRefresh: Boolean) {
        listAdapter = ReviewListAdapter(this)

        if (reviews.results.isNullOrEmpty() && isRefresh){
            viewBind.llNoReviews.visibility = View.VISIBLE
            viewBind.rvMoviesList.visibility = View.GONE
        }else{
            viewBind.llNoReviews.visibility = View.GONE
            viewBind.rvMoviesList.visibility = View.VISIBLE
            if (isRefresh) {
                listMovies = reviews.results as MutableList<Review>
                lastPage = reviews.totalPages ?: 2
            } else {
                listMovies = (listMovies + reviews.results as MutableList<Review>).toMutableList()
            }
            listAdapter.submitList(listMovies)

            viewBind.rvMoviesList.apply {
                adapter = listAdapter
                if (layoutManager == null) {
                    layoutManager = LinearLayoutManager(this@MovieDetailActivity, LinearLayoutManager.VERTICAL, false)
                }
                adapter?.notifyDataSetChanged()
            }
            viewBind.rvMoviesList.scrollToPosition(listMovies.size-19)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}