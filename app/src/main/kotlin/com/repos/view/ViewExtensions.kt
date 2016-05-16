package com.repos.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */

fun RecyclerView.linearVertical() {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    setHasFixedSize(true)
}