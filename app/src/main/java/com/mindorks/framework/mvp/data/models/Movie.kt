package com.mindorks.framework.mvp.data.models

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("popularity")
        var page: Double? = null,
        @SerializedName("vote_count")
        var totalResults: String? = null,
        @SerializedName("video")
        var video: Boolean? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("adult")
        var adult: Boolean? = null,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("original_title")
        var originalTitle: String? = null,
        @SerializedName("genre_ids")
        var genreIds: MutableList<Int>? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("overview")
        var overView: String? = null,
        @SerializedName("release_date")
        var releaseDate: String? = null
)