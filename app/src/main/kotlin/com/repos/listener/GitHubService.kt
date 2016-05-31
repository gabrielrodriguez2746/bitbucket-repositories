package com.repos.listener

import com.repos.model.PullResponseWrapper
import com.repos.model.ResponseWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
interface GitHubService {

    companion object {
        val SERVICE_ENDPOINT = "https://api.github.com"
        val REPOSITORY_TYPE = "repositoryType"
        val ORDER = "order"
        val LANGUAGE = "language"
    }

    @GET("/search/repositories")
    fun getRepositories(
            @Query("sort") sort: String,
            @Query("q") q: String,
            @Query("page") page: String): Call<ResponseWrapper>

    @GET("/repos/{creator}/{repository}/pulls")
    fun getPull(@Path("creator") creator: String, @Path("repository") repository: String)
            : Call<PullResponseWrapper>

}