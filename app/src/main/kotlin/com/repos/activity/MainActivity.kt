package com.repos.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import com.deliveriu.listener.ItemClickSupport
import com.repos.R
import com.repos.RepositoriesApp
import com.repos.adapter.RepositoriesAdapter
import com.repos.adapter.SpacesItemDecoration
import com.repos.fragment.PullRequestFragment
import com.repos.listener.GitHubService
import com.repos.model.Repositories
import com.repos.model.ResponseWrapper
import com.repos.view.*
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
        loading.show()
        setUpRepositoriesRecyclerView()
        setSwipeToRefresh()
        getRepositories()
    }

    /**
     * SetUp the [ResponseWrapper] [RecyclerView]
     */
    fun setUpRepositoriesRecyclerView() {
        rv_repositories.verticalMasonry(SpacesItemDecoration(24))
        rv_repositories.adapter = mRepositoriesAdapter
        ItemClickSupport.addTo(rv_repositories).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                addPullRequestFragment(mRepositoriesAdapter.items[position])
            }

        })
    }

    /**
     * Get [ResponseWrapper] from the web Service
     */
    fun getRepositories() {
        service.getRepositories().enqueue(object : Callback<ResponseWrapper> {
            override fun onResponse(call: Call<ResponseWrapper>?, response: Response<ResponseWrapper>?) {
                removeLoadingViews()
                if (response?.isSuccessful ?: false) mRepositoriesAdapter.items = response!!.body().items
                else showSnackBarNoInternetConnection()
            }

            override fun onFailure(call: Call<ResponseWrapper>?, t: Throwable?) {
                removeLoadingViews()
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

    /**
     * Add [PullRequestFragment] to [MainActivity] backStack
     * @param path of Pull Request to show
     */
    fun addPullRequestFragment(repository: Repositories) {
        val pullRequestFragment = PullRequestFragment()
        val arguments = Bundle()
        arguments.putString(PullRequestFragment.REPOSITORY_OWNER, repository.user.name)
        arguments.putString(PullRequestFragment.REPOSITORY_NAME, repository.name)
        pullRequestFragment.arguments = arguments
        window.setUnTouchable()
        addFragmentToBackStack(pullRequestFragment, R.id.fragment_container, PullRequestFragment.PULL_REQUEST_FRAGMENT_TAG)
    }

    /**
     * Set [SwipeRefreshLayout] behavior
     */
    fun setSwipeToRefresh() {
        swipe_refresh_layout.setOnRefreshListener {
            getRepositories()
        }
    }

    /**
     * Remove [SwipeRefreshLayout] and loading [View] after fetch the data
     */
    fun removeLoadingViews() {
        loading.hide()
        swipe_refresh_layout.isRefreshing = false
    }
}