package com.repos.view

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.LayoutInflater
import com.repos.R
import com.repos.RepositoriesApp
import com.repos.model.Repositories
import kotlinx.android.synthetic.main.respository_item_view.view.*

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class RepositoryItemView : CardView {

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
        LayoutInflater.from(context).inflate(R.layout.respository_item_view, this, true)
    }

    fun bind(repositories: Repositories) {
        RepositoriesApp.instance!!.glide.load(repositories.user.image).into(image)
        name.text = repositories.name
        owner_name.text = context.getString(R.string.owner_format_text, repositories.user.name)
        stars.text = repositories.stars
        forks.text = repositories.forks
        description.text = repositories.description
    }
}