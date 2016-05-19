package com.repos.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.deliveriu.listener.ItemClickSupport
import com.repos.R
import com.repos.RepositoriesApp
import com.repos.adapter.RepositoriesAdapter
import com.repos.listener.GitHubService
import com.repos.model.PullResponseWrapper
import com.repos.model.ResponseWrapper
import com.repos.view.hide
import com.repos.view.linearVertical
import com.repos.view.setTextColor
import com.repos.view.show
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.circular_loading.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    val mRepositoriesAdapter = RepositoriesAdapter()
    val service by lazy { RepositoriesApp.instance!!.retrofit.create(GitHubService::class.java) }

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
        ItemClickSupport.addTo(rv_repositories).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                val repository = mRepositoriesAdapter.items[position]
                service.getPull(repository.path).enqueue(object : Callback<PullResponseWrapper> {
                    override fun onResponse(call: Call<PullResponseWrapper>?, response: Response<PullResponseWrapper>?) {
                        Toast.makeText(this@MainActivity, "Todo bien", Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<PullResponseWrapper>?, t: Throwable?) {
                        Toast.makeText(this@MainActivity, "Todo mal", Toast.LENGTH_LONG).show()
                    }

                })
            }

        })
    }

    /**
     * Get [ResponseWrapper] from the web Service
     */
    fun getRepositories() {
        loading.show()
        service.getRepositories().enqueue(object : Callback<ResponseWrapper> {
            override fun onResponse(call: Call<ResponseWrapper>?, response: Response<ResponseWrapper>?) {
                loading.hide()
                if (response?.isSuccessful ?: false) mRepositoriesAdapter.items = response!!.body().items
                else showSnackBarNoInternetConnection()
            }

            override fun onFailure(call: Call<ResponseWrapper>?, t: Throwable?) {
                loading.hide()
                showSnackBarNoInternetConnection()
            }
        })
    }

    /**
     * Show [Snackbar] to retry download the data
     */
    fun showSnackBarNoInternetConnection() {
        val mSnackbar = Snackbar.make(coordinator_layout, R.string.no_internet, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.retry, { getRepositories() })
        mSnackbar.setTextColor(this, R.color.text_light)
        mSnackbar.show()
    }
}