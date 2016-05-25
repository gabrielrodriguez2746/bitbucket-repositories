package com.repos.activity

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.repos.R

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */

val BACKSTACK = "backStack"

/**
 * Launch [MainActivity] with the corresponding Flags to be a new Task
 */
fun Activity.launchMainActivityAsNewTask() {
    val intent = Intent(this, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    this.startActivity(intent)
}

/**
 * Add a Fragment to the container.
 * @param fragment to add on the Back Stack
 * @param containerId where the fragment will be place
 */
fun AppCompatActivity.addFragmentToBackStack(fragment: Fragment, containerId: Int, fragmentTag: String? = null) {
    this.supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,
            R.anim.enter_from_right, R.anim.exit_to_right).add(containerId, fragment, fragmentTag ?: fragment.tag)
            .addToBackStack(BACKSTACK).commit()
}