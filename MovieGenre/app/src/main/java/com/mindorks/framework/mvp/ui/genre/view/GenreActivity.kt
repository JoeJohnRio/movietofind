package com.mindorks.framework.mvp.ui.login.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.models.Genre
import com.mindorks.framework.mvp.databinding.ActivityGenreBinding
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.genre.view.GenreListAdapter
import com.mindorks.framework.mvp.ui.login.presenter.GenreMVPPresenter
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class GenreActivity : BaseActivity(), GenreMVPView {
    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    internal lateinit var presenter: GenreMVPPresenter<GenreMVPView>
    lateinit var viewBind: ActivityGenreBinding
    lateinit var listAdapter: GenreListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = DataBindingUtil.setContentView(this, R.layout.activity_genre)
        presenter.onAttach(this)
        presenter.getGenre()
    }

    override fun setGenreList(genres: Genre) {
        listAdapter = GenreListAdapter(this)

        listAdapter.submitList(genres.listOfGenre)
        viewBind.rvGenreList.apply {
            adapter = listAdapter
            if (layoutManager == null) {
                layoutManager = LinearLayoutManager(this@GenreActivity, LinearLayoutManager.VERTICAL, false)
            }
            adapter?.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}