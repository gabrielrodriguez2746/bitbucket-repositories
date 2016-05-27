package com.repos.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View

/**
 * Allows create spaces between grid view images
 * @author Gabriel Rodriguez
 * @version 1.0.0
 */

class SpacesItemDecoration(space: Int) : RecyclerView.ItemDecoration() {
    var mSpace: Int = 0

    init {
        this.mSpace = space
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val spanIndex = (view.layoutParams as StaggeredGridLayoutManager.LayoutParams).spanIndex
        // Add half lateral margin depending of the item position
        if (spanIndex == 0) {
            outRect.left = mSpace
            outRect.right = mSpace / 2
        } else {
            outRect.left = mSpace / 2
            outRect.right = mSpace
        }
        outRect.bottom = mSpace
    }
}