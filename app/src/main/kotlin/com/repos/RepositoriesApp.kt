package com.repos

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */

class RepositoriesApp : Application() {

    val glide: RequestManager by lazy { Glide.with(this) }

    companion object {
        var instance: RepositoriesApp? = null
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}