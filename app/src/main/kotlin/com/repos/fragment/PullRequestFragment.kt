package com.repos.fragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deliveriu.listener.ItemClickSupport
import com.repos.R
import com.repos.RepositoriesApp
import com.repos.activity.MainActivity
import com.repos.adapter.PullRequestAdapter
import com.repos.model.PullResponseWrapper
import com.repos.model.Repositories
import com.repos.view.hide
import com.repos.view.linearVertical
import com.repos.view.show
import com.repos.view.tint
import kotlinx.android.synthetic.main.circular_loading.*
import kotlinx.android.synthetic.main.fragment_pull_request.*
import kotlinx.android.synthetic.main.pull_header_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class PullRequestFragment : BaseAnimateFragment() {

    val mPullRequestAdapter = PullRequestAdapter()
    var fragmentArguments: Bundle? = null
    var rootView: View? = null
    val repository by lazy { fragmentArguments?.getSerializable(REPOSITORY) as Repositories }
    val toolbar by lazy { rootView?.findViewById(R.id.toolbar) as Toolbar }

    companion object {
        val PULL_REQUEST_FRAGMENT_TAG = "pullRequestFragment"
        val REPOSITORY = "repository"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retainInstance = true
        return inflater?.inflate(R.layout.fragment_pull_request, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentArguments = arguments
        rootView = view
        setupToolbar()
        setupPullRequestRecyclerView()
        setupSwipeToRefresh()
        loading.show()
        activity.runOnUiThread { bindRepository() }
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
        (activity as MainActivity).service.getPull(repository.user.name, repository.name).enqueue(object : Callback<PullResponseWrapper> {
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
    fun setupSwipeToRefresh() {
        fragment_swipe_refresh_layout.setOnRefreshListener {
            getPullRequest()
        }
    }

    fun bindRepository() {
        RepositoriesApp.instance!!.glide.load(repository.user.image).into(image)
        name.text = repository.name
        stars.text = repository.stars
        stars.compoundDrawables[0].tint(context, R.color.text_light)
        forks.text = repository.forks
        forks.compoundDrawables[0].tint(context, R.color.text_light)
    }


    private fun setupToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener { activity.onBackPressed() }
    }
}