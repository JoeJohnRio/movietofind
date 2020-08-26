package com.mindorks.framework.mvp.ui.login.view

import com.mindorks.framework.mvp.data.models.Genre
import com.mindorks.framework.mvp.ui.base.view.MVPView

/**
 * Created by jyotidubey on 10/01/18.
 */
interface GenreMVPView : MVPView {

    fun setGenreList(genres: Genre)

}