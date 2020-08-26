package com.mindorks.framework.mvp.data.models

import com.google.gson.annotations.SerializedName

data class Reviews(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("page")
        var page: Int? = null,
        @SerializedName("total_results")
        var totalResults: String? = null,
        @SerializedName("total_pages")
        var totalPages: Int? = null,
        @SerializedName("results")
        var results: MutableList<Review>? = null
)