package com.repos.activity

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.repos.R

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            launchMainActivityAsNewTask()
            finish()
        }, 1000)
    }

}
