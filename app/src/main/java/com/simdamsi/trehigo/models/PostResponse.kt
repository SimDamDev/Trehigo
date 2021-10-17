package com.simdamsi.trehigo.models

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class PostResponse(
    @Json(name = "data")
    val data: List<Post>?
)