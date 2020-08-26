package com.mindorks.framework.mvp.data.network

import com.mindorks.framework.mvp.data.models.Genre
import com.mindorks.framework.mvp.data.models.MoviesPage
import com.mindorks.framework.mvp.data.models.Reviews
import com.mindorks.framework.mvp.data.models.YoutubeKeys
import io.reactivex.Observable
import retrofit2.http.*

interface INetworkApi {

    @GET(ApiEndPoint.GENRE_LIST)
    fun getMovieGenre(@Query("api_key") apiKey: String, @Query("language") language: String): Observable<Genre>

    @GET(ApiEndPoint.MOVIE_PAGE)
    fun getMovies(@Query("api_key") apiKey: String, @Query("with_genres") genre: Int,  @Query("page") page: Int): Observable<MoviesPage>

    @GET(ApiEndPoint.MOVIE_REVIEWS)
    fun getReviews(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String, @Query("page") page: Int): Observable<Reviews>

    @GET(ApiEndPoint.YOUTUBE_KEY)
    fun getYoutubeKey(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String): Observable<YoutubeKeys>

}