package com.mindorks.framework.mvp.data.models

import com.google.gson.annotations.SerializedName

data class MoviesPage(
        @SerializedName("page")
        var page: Int? = null,
        @SerializedName("total_results")
        var totalResults: String? = null,
        @SerializedName("total_pages")
        var totalPages: Int? = null,
        @SerializedName("results")
        var results: MutableList<Movie>? = null
)