package com.repos.activity

import android.app.Activity
import android.content.Intent

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */

/**
 * Launch [MainActivity] with the corresponding Flags to be a new Task
 */
fun Activity.launchMainActivityAsNewTask() {
    val intent = Intent(this, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    this.startActivity(intent)
}