package com.mindorks.framework.mvp.ui.login.presenter

import com.mindorks.framework.mvp.data.network.INetworkApi
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.login.view.GenreMVPView
import com.mindorks.framework.mvp.util.AppConstants
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.schedulers.IoScheduler
import javax.inject.Inject

/**
 * Created by jyotidubey on 10/01/18.
 */
class GenrePresenter<V : GenreMVPView> @Inject internal constructor(schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V>(schedulerProvider = schedulerProvider, compositeDisposable = disposable), GenreMVPPresenter<V> {

    @Inject
    lateinit var mNetworkApi: INetworkApi

    override fun getGenre() {
        getView()?.let {
            it.showProgress()
            addDisposable(mNetworkApi.getMovieGenre(AppConstants.API_KEY, AppConstants.LANGUAGE).subscribeOn(IoScheduler()).observeOn(
                    AndroidSchedulers.mainThread()
            ).subscribe(
                    { result ->
                        it.hideProgress()
                        it.setGenreList(result)
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