package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView
import com.mindorks.framework.mvp.ui.login.view.MovieDetailMVPView
import com.mindorks.framework.mvp.ui.login.view.MoviesMVPView

/**
 * Created by jyotidubey on 10/01/18.
 */
interface MovieDetailMVPPresenter<V : MovieDetailMVPView> : MVPPresenter<V> {

    fun getReviews(movieId: Int, pageNumber: Int, isRefresh: Boolean)

    fun getYoutubeKey(movieId: Int)

}