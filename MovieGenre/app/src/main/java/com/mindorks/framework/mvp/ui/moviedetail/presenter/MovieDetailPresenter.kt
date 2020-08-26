package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.data.network.INetworkApi
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView
import com.mindorks.framework.mvp.ui.login.view.MovieDetailMVPView
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
class MovieDetailPresenter<V : MovieDetailMVPView> @Inject internal constructor(schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V>(schedulerProvider = schedulerProvider, compositeDisposable = disposable), MovieDetailMVPPresenter<V> {
    @Inject
    lateinit var mNetworkApi: INetworkApi

    override fun getYoutubeKey(movieId: Int) {
        getView()?.let {
            it.showProgress()
            addDisposable(mNetworkApi.getYoutubeKey(movieId, AppConstants.API_KEY).subscribeOn(IoScheduler()).observeOn(
                    AndroidSchedulers.mainThread()
            ).subscribe(
                    { result ->
                        it.hideProgress()
                        it.setYoutubeKeys(result)
                    },
                    { error ->
                        it.hideProgress()
                        it.showMessageToast(error.message ?: "")
                    }
            )
            )
        }
    }

    override fun getReviews(movieId: Int, pageNumber: Int, isRefresh: Boolean) {
        getView()?.let {
            it.showProgress()
            if (isRefresh) {
                addDisposable(mNetworkApi.getReviews(movieId, AppConstants.API_KEY, 1).subscribeOn(IoScheduler()).observeOn(
                        AndroidSchedulers.mainThread()
                ).subscribe(
                        { result ->
                            it.hideProgress()
                            it.setReviews(result, true)
                        },
                        { error ->
                            it.hideProgress()
                            it.showMessageToast(error.message ?: "")
                        }
                )
                )
            } else {
                addDisposable(mNetworkApi.getReviews(movieId, AppConstants.API_KEY, pageNumber).subscribeOn(IoScheduler()).observeOn(
                        AndroidSchedulers.mainThread()
                ).subscribe(
                        { result ->
                            it.hideProgress()
                            it.setReviews(result, false)
                        },
                        { error ->
                            it.hideProgress()
                            it.showMessageToast(error.message ?: "")
                        }
                )
                )
            }

        }
    }


}