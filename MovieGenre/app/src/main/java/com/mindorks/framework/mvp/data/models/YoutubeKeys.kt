package com.mindorks.framework.mvp.data.models

import com.google.gson.annotations.SerializedName

data class YoutubeKeys(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("results")
        var results: MutableList<YoutubeKey>? = null
)