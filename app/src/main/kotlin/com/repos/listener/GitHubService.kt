package com.repos.listener

import com.repos.model.Response
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

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
            @Query("page") page: String = "1"): Observable<Response>

}