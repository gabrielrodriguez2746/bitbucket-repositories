package com.repos.model

import com.google.gson.annotations.SerializedName

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 * Allows to get the repository data from web service Response
 */
class Repositories {

    @SerializedName("id") lateinit var id: String
    @SerializedName("name") lateinit var name: String
    @SerializedName("full_name") lateinit var path: String
    @SerializedName("stargazers_count") lateinit var stars: String
    @SerializedName("forks_count") lateinit var forks: String
    @SerializedName("owner") lateinit var user: Owner

}