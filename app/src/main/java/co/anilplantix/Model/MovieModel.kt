package co.anilplantix.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class MovieModel(
        @SerializedName("title")
        @Expose
        var title: String? = null,
        @SerializedName("image")
        @Expose
        var imageHref: String? = null
       )
