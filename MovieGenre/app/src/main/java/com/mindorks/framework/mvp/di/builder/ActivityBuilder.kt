package com.mindorks.framework.mvp.di.builder

import com.mindorks.framework.mvp.ui.login.GenreActivityModule
import com.mindorks.framework.mvp.ui.login.MovieDetailActivityModule
import com.mindorks.framework.mvp.ui.login.MoviesActivityModule
import com.mindorks.framework.mvp.ui.login.view.GenreActivity
import com.mindorks.framework.mvp.ui.login.view.MovieDetailActivity
import com.mindorks.framework.mvp.ui.login.view.MoviesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(GenreActivityModule::class)])
    abstract fun bindGenreActivity(): GenreActivity

    @ContributesAndroidInjector(modules = [(MoviesActivityModule::class)])
    abstract fun bindMoviesActivity(): MoviesActivity

    @ContributesAndroidInjector(modules = [(MovieDetailActivityModule::class)])
    abstract fun bindMovieDetailActivity(): MovieDetailActivity

}