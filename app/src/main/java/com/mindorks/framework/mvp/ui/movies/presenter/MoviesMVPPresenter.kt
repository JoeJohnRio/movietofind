package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView
import com.mindorks.framework.mvp.ui.login.view.MoviesMVPView

/**
 * Created by jyotidubey on 10/01/18.
 */
interface MoviesMVPPresenter<V : MoviesMVPView> : MVPPresenter<V> {

    fun getMovies(genre: Int, pageNumber: Int, isRefresh: Boolean)

}