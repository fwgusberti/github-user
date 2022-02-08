package br.com.nerdrapido.myapplication.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created By FELIPE GUSBERTI @ 08/02/2022
 */
data class User(
    val name: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String
)