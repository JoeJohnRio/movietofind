package com.mindorks.framework.mvp.ui.login

import com.mindorks.framework.mvp.ui.login.presenter.*
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView
import com.mindorks.framework.mvp.ui.login.view.MovieDetailMVPView
import com.mindorks.framework.mvp.ui.login.view.MoviesMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 10/01/18.
 */
@Module
class MovieDetailActivityModule {
    @Provides
    internal fun provideMovieDetailPresenter(presenter: MovieDetailPresenter<MovieDetailMVPView>)
            : MovieDetailMVPPresenter<MovieDetailMVPView> = presenter

}