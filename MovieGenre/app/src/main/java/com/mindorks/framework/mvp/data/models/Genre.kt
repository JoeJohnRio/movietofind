package com.mindorks.framework.mvp.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by jyotidubey on 17/01/18.
 */
data class Genre(
        @SerializedName("genres")
        var listOfGenre: MutableList<Genres>? = null
)

data class Genres(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("name")
        var name: String? = null
)