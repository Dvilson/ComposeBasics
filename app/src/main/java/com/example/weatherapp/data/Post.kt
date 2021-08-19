package com.example.weatherapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(

    val id :Int,
    val slug:String,
    val status :String,

    val title :Title,
    val content :Content,
    val link:String,
    val date_gmt :String ,
    val date :String,
    @SerializedName("jetpack_featured_media_url")
    val image:String

):Parcelable{

    @Parcelize
    data class Content(@SerializedName("rendered")val contenu:String ):Parcelable

    @Parcelize
    data class  Title(val rendered: String):Parcelable


}