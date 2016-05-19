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
    }

    @GET("/search/repositories")
    fun getRepositories(
            @Query("sort") sort: String = "stars",
            @Query("q") q: String = "language:Java",
            @Query("page") page: String = "1"): Call<ResponseWrapper>

    @GET("/repos/{path}/pulls")
    fun getPull(@Path("path") path: String) : Call<PullResponseWrapper>

}