package com.repos.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 * Allows to get data from web service Response
 */
class Response {

    @SerializedName("items") lateinit var items: ArrayList<Repositories>

}