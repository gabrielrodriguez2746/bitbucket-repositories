package com.repos.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.repos.R
import com.repos.model.Repositories

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class RepositoryItemView : LinearLayout {

    val name by lazy { findViewById(R.id.name) as TextView }

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
        name.text = repositories.name
    }
}