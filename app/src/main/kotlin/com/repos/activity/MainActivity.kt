package com.repos.activity

import android.os.Bundle
import com.repos.R
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
    }

    fun setupToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_menu)
    }
}