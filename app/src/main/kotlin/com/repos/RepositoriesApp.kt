package com.repos

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.repos.listener.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */

class RepositoriesApp : Application() {

    val glide: RequestManager by lazy { Glide.with(this) }
    val retrofit by lazy {
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(GitHubService.SERVICE_ENDPOINT).build()
    }

    companion object {
        var instance: RepositoriesApp? = null
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        // Calligraphy Initialize
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder().setDefaultFontPath(getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath).build())
    }
}