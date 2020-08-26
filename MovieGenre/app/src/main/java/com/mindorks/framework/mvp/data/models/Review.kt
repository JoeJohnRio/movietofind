package com.mindorks.framework.mvp.data.models

import com.google.gson.annotations.SerializedName

data class Review(
        @SerializedName("author")
        var author: String? = null,
        @SerializedName("content")
        var content: String? = null,
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("url")
        var url: String? = null
)