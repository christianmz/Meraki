package com.meazza.meraki.data.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnsplashPhoto(
    @SerializedName("id")
    val id: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("urls")
    val urls: UnsplashPhotoUrls,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("user")
    val user: UnsplashUser
) : Parcelable {

    @Parcelize
    data class UnsplashPhotoUrls(
        @SerializedName("full")
        val full: String,
        @SerializedName("raw")
        val raw: String,
        @SerializedName("regular")
        val regular: String,
        @SerializedName("small")
        val small: String,
        @SerializedName("thumb")
        val thumb: String
    ) : Parcelable

    @Parcelize
    data class UnsplashUser(
        @SerializedName("name")
        val name: String,
        @SerializedName("username")
        val username: String,
        @SerializedName("instagram_username")
        val instagramUsername: String,
    ) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=Unsplash&utm_medium=referral"
    }
}