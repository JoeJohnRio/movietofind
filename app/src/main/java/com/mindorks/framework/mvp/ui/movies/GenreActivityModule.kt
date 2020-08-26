package com.mindorks.framework.mvp.ui.login

import com.mindorks.framework.mvp.ui.login.presenter.GenreMVPPresenter
import com.mindorks.framework.mvp.ui.login.presenter.GenrePresenter
import com.mindorks.framework.mvp.ui.login.presenter.MoviesMVPPresenter
import com.mindorks.framework.mvp.ui.login.presenter.MoviesPresenter
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView
import com.mindorks.framework.mvp.ui.login.view.MoviesMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 10/01/18.
 */
@Module
class MoviesActivityModule {
    @Provides
    internal fun provideMoviesPresenter(presenter: MoviesPresenter<MoviesMVPView>)
            : MoviesMVPPresenter<MoviesMVPView> = presenter

}