package com.mindorks.framework.mvp.ui.login.view

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.Genre
import com.mindorks.framework.mvp.data.models.Movie
import com.mindorks.framework.mvp.data.models.MoviesPage
import com.mindorks.framework.mvp.databinding.ActivityGenreBinding
import com.mindorks.framework.mvp.databinding.ActivityMoviesBinding
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.genre.view.GenreListAdapter
import com.mindorks.framework.mvp.ui.genre.view.MoviesListAdapter
import com.mindorks.framework.mvp.ui.login.presenter.GenreMVPPresenter
import com.mindorks.framework.mvp.ui.login.presenter.MoviesMVPPresenter
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class MoviesActivity : BaseActivity(), MoviesMVPView {
    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    internal lateinit var presenter: MoviesMVPPresenter<MoviesMVPView>
    lateinit var viewBind: ActivityMoviesBinding
    lateinit var listAdapter: MoviesListAdapter
    var listMovies: MutableList<Movie> = mutableListOf()
    var genres = 1
    var pageNumber = 1
    var lastPage = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = DataBindingUtil.setContentView(this, R.layout.activity_movies)
        presenter.onAttach(this)
        genres = intent.getIntExtra("tvMovieId", 1)
        viewBind.tvGenreTitle.text = intent.getStringExtra("genreName") ?: "Genre"
        listAdapter = MoviesListAdapter(this)
        listAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT
        presenter.getMovies(genres, pageNumber, true)

        viewBind.rvMoviesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    if (lastPage >= pageNumber) {
                        Log.d("onScrolled", "Sedang scroll")
                        pageNumber++
                        presenter.getMovies(genres, pageNumber, false)
                    }
                }
            }
        })
    }

    override fun setMovies(moviesPage: MoviesPage, isRefresh: Boolean) {
        listAdapter = MoviesListAdapter(this)

        if (isRefresh) {
            listMovies = moviesPage.results as MutableList<Movie>
            lastPage = moviesPage.totalPages ?: 2
        } else {
            listMovies = (listMovies + moviesPage.results as MutableList<Movie>).toMutableList()
        }
        listAdapter.submitList(listMovies)

        viewBind.rvMoviesList.apply {
//            if (adapter == null){
                adapter = listAdapter
//            }
            if (layoutManager == null) {
                layoutManager = LinearLayoutManager(this@MoviesActivity, LinearLayoutManager.VERTICAL, false)
            }
            adapter?.notifyDataSetChanged()
        }

        viewBind.rvMoviesList.scrollToPosition(listMovies.size-19)


    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}