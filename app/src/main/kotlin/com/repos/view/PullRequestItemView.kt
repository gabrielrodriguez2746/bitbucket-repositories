package com.repos.view

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.LayoutInflater
import com.repos.R
import com.repos.RepositoriesApp
import com.repos.model.PullRequest
import kotlinx.android.synthetic.main.pull_request_item_view.view.*

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class PullRequestItemView : CardView {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    fun init() {
        LayoutInflater.from(context).inflate(R.layout.pull_request_item_view, this, true)
    }

    fun bind(pullRequest: PullRequest) {
        RepositoriesApp.instance!!.glide.load(pullRequest.user.image).into(image)
        name.text = pullRequest.title
        owner_name.text = context.getString(R.string.owner_format_text, pullRequest.user.name)
        state_name.text = pullRequest.state
    }
}