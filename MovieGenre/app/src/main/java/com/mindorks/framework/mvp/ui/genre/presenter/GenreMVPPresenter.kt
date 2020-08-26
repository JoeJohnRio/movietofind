package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView

/**
 * Created by jyotidubey on 10/01/18.
 */
interface GenreMVPPresenter<V : GenreMVPView> : MVPPresenter<V> {

    fun getGenre()

}