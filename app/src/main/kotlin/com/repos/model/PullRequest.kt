package com.repos.model

import com.google.gson.annotations.SerializedName

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class PullRequest {

    @SerializedName("id") lateinit var id: String
    @SerializedName("html_url") lateinit var url: String
    @SerializedName("state") lateinit var state: String
    @SerializedName("title") lateinit var title: String
    @SerializedName("body") lateinit var description: String
    @SerializedName("user") lateinit var user: Owner

}