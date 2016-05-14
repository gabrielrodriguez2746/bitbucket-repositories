package com.repos.bitbucketrepositories

import android.app.Application

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */

class RepositoriesApp : Application() {

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        var instance: RepositoriesApp? = null
    }
}
