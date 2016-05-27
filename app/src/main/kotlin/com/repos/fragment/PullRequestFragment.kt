package com.repos.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.repos.R

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class PullRequestFragment : BaseAnimateFragment() {

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
    }

}