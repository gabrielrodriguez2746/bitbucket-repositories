package com.repos.adapter

import android.view.ViewGroup
import com.repos.model.Repositories
import com.repos.view.RepositoryItemView

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class RepositoriesAdapter : RecyclerViewBaseAdapter<Repositories, RepositoryItemView>() {

    override fun onCreateItemView(parent: ViewGroup, viewType: Int): RepositoryItemView {
        return RepositoryItemView(parent.context)
    }

    override fun onBindViewHolder(holder: ViewWrapper<RepositoryItemView>?, position: Int) {
        val repository = items[position]
        holder?.view?.bind(repository)
    }
}