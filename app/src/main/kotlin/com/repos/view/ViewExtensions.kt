package com.repos.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */

/**
 * Configure a [RecyclerView] As a Vertical
 */
fun RecyclerView.linearVertical() {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    setHasFixedSize(true)
}

/**
 * Make a [View] Visible
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * Make a [View] Invisible
 */
fun View.hide() {
    visibility = View.GONE
}