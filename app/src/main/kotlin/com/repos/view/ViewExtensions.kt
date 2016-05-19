package com.repos.view

import android.content.Context
import android.support.design.R
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

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

fun Snackbar.setTextColor(context: Context, colorResource: Int) {
    (this.view.findViewById(R.id.snackbar_text) as TextView)
            .setTextColor(ContextCompat.getColor(context, colorResource))
}