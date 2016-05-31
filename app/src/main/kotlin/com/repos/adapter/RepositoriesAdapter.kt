package com.repos.adapter

import android.view.ViewGroup
import com.repos.listener.EndlessScrollListener
import com.repos.model.Repositories
import com.repos.view.RepositoryItemView

/**
 * @author Gabriel Rodriguez
 * @version 1.0.1
 */
class RepositoriesAdapter : RecyclerViewBaseAdapter<Repositories, RepositoryItemView>() {

    // Listener and Variables to implements infinite scroll
    internal var endlessScrollListener: EndlessScrollListener? = null
        set(listener) {
            field = listener
        }
    internal val VISIBLE_THRESHOLD = 5

    override fun onCreateItemView(parent: ViewGroup, viewType: Int): RepositoryItemView {
        return RepositoryItemView(parent.context)
    }

    override fun onBindViewHolder(holder: ViewWrapper<RepositoryItemView>?, position: Int) {
        val repository = items[position]
        holder?.view?.bind(repository)
        if (position == itemCount - VISIBLE_THRESHOLD) endlessScrollListener?.onLoadMore()
    }
}