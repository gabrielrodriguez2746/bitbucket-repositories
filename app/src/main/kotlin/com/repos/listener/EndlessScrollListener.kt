package com.repos.listener

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
interface EndlessScrollListener {

    /**
     * To use in RecyclerViewAdapter to notify if it is necessary load more data
     */
    fun onLoadMore()
}