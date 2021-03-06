package com.repos.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * @author Samuel Barbosa
 * @version 1.0.1
 * Copied from his owner.
 * It's reduce the code to create a [RecyclerView] Adapter
 */
abstract class RecyclerViewBaseAdapter<T, V : View> : RecyclerView.Adapter<ViewWrapper<V>>() {

    var items: MutableList<T> = ArrayList()
        set(items) {
            field = items
            notifyDataSetChanged()
        }

    fun addItems(items: MutableList<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewWrapper<V> {
        return ViewWrapper(onCreateItemView(parent, viewType))
    }

    protected abstract fun onCreateItemView(parent: ViewGroup, viewType: Int): V
}