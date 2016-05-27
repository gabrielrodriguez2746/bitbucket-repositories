package com.repos.fragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deliveriu.listener.ItemClickSupport
import com.repos.R
import com.repos.adapter.PullRequestAdapter
import com.repos.view.linearVertical
import kotlinx.android.synthetic.main.fragment_pull_request.*

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class PullRequestFragment : BaseAnimateFragment() {

    val pullRequestAdapter = PullRequestAdapter()

    companion object {
        val PULL_REQUEST_FRAGMENT_TAG = "pullRequestFragment"
        val REPOSITORY_PULL_REQUEST = "repositoryPullRequest"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retainInstance = true
        return inflater?.inflate(R.layout.fragment_pull_request, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPullRequestRecyclerView()
    }

    /**
     * Setup the [PullRequest] [RecyclerView]
     */
    fun setupPullRequestRecyclerView() {
        rv_pull_request.linearVertical()
        rv_pull_request.adapter = pullRequestAdapter
        ItemClickSupport.addTo(rv_pull_request).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener{
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                // Launch intent
            }

        })
    }

}