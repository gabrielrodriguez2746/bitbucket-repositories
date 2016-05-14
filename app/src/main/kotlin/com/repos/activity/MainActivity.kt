package com.repos.activity

import android.os.Bundle
import android.view.Gravity
import com.repos.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
    }

    fun setupToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_menu)
        toolbar.setNavigationOnClickListener { drawer.openDrawer(navigation_view) }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.START)) {
            drawer.closeDrawers()
            return
        }
        super.onBackPressed()
    }
}