package com.mindorks.framework.mvp.data.models

import com.google.gson.annotations.SerializedName

data class YoutubeKey(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("iso_639_1")
        var isoOne: String? = null,
        @SerializedName("iso_3166_1")
        var isoTwo: String? = null,
        @SerializedName("key")
        var key: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("site")
        var site: String? = null,
        @SerializedName("size")
        var size: Int? = null,
        @SerializedName("type")
        var type: String? = null
)