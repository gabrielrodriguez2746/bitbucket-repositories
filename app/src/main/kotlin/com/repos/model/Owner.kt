package com.repos.model

import com.google.gson.annotations.SerializedName

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 * Allows to get the user data from web service Response
 */
class Owner {

    @SerializedName("login") lateinit var name: String
    @SerializedName("avatar_url") lateinit var image: String

}
