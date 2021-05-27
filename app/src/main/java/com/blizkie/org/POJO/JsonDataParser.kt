package com.blizkie.org.model

import com.google.gson.annotations.SerializedName

data class JsonParty(

    @SerializedName("title") var title: String,
    @SerializedName("header_banner") var headerBanner: String,
    @SerializedName("name_inventer") var nameInventer: String,
    @SerializedName("photo_inventer") var photoInventer: String,
    @SerializedName("user_initiator") var userInitiator: String,
    @SerializedName("guests") var guests: List<Guests>

)

data class Guests(

    @SerializedName("name") var name: String,
    @SerializedName("avatar") var avatar: String

)
