package com.repos.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author Samuel Barbosa
 * @version 1.0
 * Copied from his owner.
 * It's reduce the code to create a [RecyclerView] Adapter
 */
class ViewWrapper<V : View>(val view: V) : RecyclerView.ViewHolder(view) {
}