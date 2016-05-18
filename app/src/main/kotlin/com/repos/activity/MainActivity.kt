package com.repos.activity

import android.os.Bundle
import com.repos.R
import com.repos.RepositoriesApp
import com.repos.adapter.RepositoriesAdapter
import com.repos.listener.GitHubService
import com.repos.model.ResponseWrapper
import com.repos.view.hide
import com.repos.view.linearVertical
import com.repos.view.show
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.circular_loading.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    val mRepositoriesAdapter = RepositoriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRepositoriesRecyclerView()
        getRepositories()
    }

    /**
     * SetUp the [ResponseWrapper] [RecyclerView]
     */
    fun setUpRepositoriesRecyclerView() {
        rv_repositories.linearVertical()
        rv_repositories.adapter = mRepositoriesAdapter
    }

    /**
     * Get [ResponseWrapper] from the web Service
     */
    fun getRepositories() {
        loading.show()
        val service = RepositoriesApp.instance!!.retrofit.create(GitHubService::class.java)
        service.getRepositories().enqueue(object : Callback<ResponseWrapper> {
            override fun onResponse(call: Call<ResponseWrapper>?, response: Response<ResponseWrapper>?) {
                loading.hide()
                if (response?.isSuccessful ?: false) mRepositoriesAdapter.items = response!!.body().items
                // else SnackBar Error and Retry
            }

            override fun onFailure(call: Call<ResponseWrapper>?, t: Throwable?) {
                loading.hide()
                //Show SnackBar Error and retry
            }

        })
    }
}

