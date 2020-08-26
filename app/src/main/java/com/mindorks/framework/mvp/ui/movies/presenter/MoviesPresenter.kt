package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.data.network.INetworkApi
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView
import com.mindorks.framework.mvp.ui.login.view.MoviesMVPView
import com.mindorks.framework.mvp.util.AppConstants
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.schedulers.IoScheduler
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class MoviesPresenter<V : MoviesMVPView> @Inject internal constructor(schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V>(schedulerProvider = schedulerProvider, compositeDisposable = disposable), MoviesMVPPresenter<V> {
    @Inject
    lateinit var mNetworkApi: INetworkApi

    override fun getMovies(genre: Int, pageNumber: Int, isRefresh: Boolean) {
        getView()?.let {
            if (isRefresh) {
                addDisposable(mNetworkApi.getMovies(AppConstants.API_KEY, genre, 1).subscribeOn(IoScheduler()).observeOn(
                        AndroidSchedulers.mainThread()
                ).subscribe(
                        { result ->
                            it.setMovies(result, true)
                        },
                        { error ->
                            it.showMessageToast(error.message ?: "")
                        }
                )
                )
            }else{
                addDisposable(mNetworkApi.getMovies(AppConstants.API_KEY, genre, pageNumber).subscribeOn(IoScheduler()).observeOn(
                        AndroidSchedulers.mainThread()
                ).subscribe(
                        { result ->
                            it.setMovies(result, false)
                        },
                        { error ->
                            it.showMessageToast(error.message ?: "")
                        }
                )
                )
            }

        }
    }


}