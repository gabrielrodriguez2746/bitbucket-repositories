package com.repos.fragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deliveriu.listener.ItemClickSupport
import com.repos.R
import com.repos.activity.MainActivity
import com.repos.adapter.PullRequestAdapter
import com.repos.model.PullResponseWrapper
import com.repos.view.hide
import com.repos.view.linearVertical
import com.repos.view.show
import kotlinx.android.synthetic.main.circular_loading.*
import kotlinx.android.synthetic.main.fragment_pull_request.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class PullRequestFragment : BaseAnimateFragment() {

    val mPullRequestAdapter = PullRequestAdapter()
    var fragmentArguments : Bundle? = null
    val repositoryName by lazy { fragmentArguments?.getString(REPOSITORY_NAME) }
    val repositoryOwner by lazy { fragmentArguments?.getString(REPOSITORY_OWNER) }

    companion object {
        val PULL_REQUEST_FRAGMENT_TAG = "pullRequestFragment"
        val REPOSITORY_OWNER = "repositoryOwner"
        val REPOSITORY_NAME = "repositoryName"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retainInstance = true
        return inflater?.inflate(R.layout.fragment_pull_request, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentArguments = arguments
        setupPullRequestRecyclerView()
        setSwipeToRefresh()
        loading.show()
        getPullRequest()
    }

    /**
     * Setup the [PullRequest] [RecyclerView]
     */
    fun setupPullRequestRecyclerView() {
        rv_pull_request.linearVertical()
        rv_pull_request.adapter = mPullRequestAdapter
        ItemClickSupport.addTo(rv_pull_request).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                // Launch intent
            }

        })
    }

    /**
     * Get [PullRequestWrappr] from the web Service
     */
    private fun getPullRequest() {
        (activity as MainActivity).service.getPull(repositoryOwner!!, repositoryName!!).enqueue(object : Callback<PullResponseWrapper> {
            override fun onResponse(call: Call<PullResponseWrapper>?, response: Response<PullResponseWrapper>?) {
                removeLoadingViews()
                if (response?.isSuccessful ?: false) {
                    mPullRequestAdapter.items = response!!.body()
                } else {
                    // Reload data
                }
            }

            override fun onFailure(call: Call<PullResponseWrapper>?, t: Throwable?) {
                removeLoadingViews()
                // Reload data
            }

        })
    }

    /**
     * Remove [SwipeRefreshLayout] and loading [View] after fetch the data
     */
    fun removeLoadingViews() {
        loading.hide()
        fragment_swipe_refresh_layout.isRefreshing = false
    }

    /**
     * Set [SwipeRefreshLayout] behavior
     */
    fun setSwipeToRefresh() {
        fragment_swipe_refresh_layout.setOnRefreshListener {
            getPullRequest()
        }
    }
}