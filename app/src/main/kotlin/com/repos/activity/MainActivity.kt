package com.repos.activity

import android.os.Bundle
import com.repos.R
import com.repos.RepositoriesApp
import com.repos.adapter.RepositoriesAdapter
import com.repos.listener.GitHubService
import com.repos.view.linearVertical
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : BaseActivity() {

    val mRepositoriesAdapter = RepositoriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRepositoriesRecyclerView()
        getRepositories()
    }

    fun setUpRepositoriesRecyclerView() {
        rv_repositories.linearVertical()
        rv_repositories.adapter = mRepositoriesAdapter
    }

    fun getRepositories() {
        val service = RepositoriesApp.instance!!.retrofit.create(GitHubService::class.java)
        service.getRepositories().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response ->
                    mRepositoriesAdapter.items = response.items
                }
    }
}

