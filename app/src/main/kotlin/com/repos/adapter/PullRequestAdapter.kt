package com.repos.adapter

import android.view.ViewGroup
import com.repos.model.PullRequest
import com.repos.view.PullRequestItemView

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class PullRequestAdapter : RecyclerViewBaseAdapter<PullRequest, PullRequestItemView>() {

    override fun onCreateItemView(parent: ViewGroup, viewType: Int): PullRequestItemView {
        return PullRequestItemView(parent.context)
    }

    override fun onBindViewHolder(holder: ViewWrapper<PullRequestItemView>?, position: Int) {
        val pullRequest = items[position]
        holder?.view?.bind(pullRequest)
    }
}