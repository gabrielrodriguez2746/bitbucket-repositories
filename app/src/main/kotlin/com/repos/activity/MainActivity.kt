package com.repos.activity

import android.os.Bundle
import android.util.Log
import com.repos.R
import com.repos.RepositoriesApp
import com.repos.listener.GitHubService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = RepositoriesApp.instance!!.retrofit.create(GitHubService::class.java)
        service.getRepositories().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response -> Log.d("MainActivity", "Response :: " + response.items) }

    }
}

