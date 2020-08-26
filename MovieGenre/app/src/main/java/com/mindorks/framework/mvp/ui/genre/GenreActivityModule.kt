package com.mindorks.framework.mvp.ui.login

import com.mindorks.framework.mvp.ui.login.presenter.GenreMVPPresenter
import com.mindorks.framework.mvp.ui.login.presenter.GenrePresenter
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by jyotidubey on 10/01/18.
 */
@Module
class GenreActivityModule {
    @Provides
    internal fun provideGenrePresenter(presenter: GenrePresenter<GenreMVPView>)
            : GenreMVPPresenter<GenreMVPView> = presenter

}