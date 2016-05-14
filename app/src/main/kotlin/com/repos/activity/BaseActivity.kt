package com.repos.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**@author Gabriel Rodriguez
 * @version 1.0
 */

open class BaseActivity : AppCompatActivity() {

    /**
     * Necessary method to use [CalligraphyContextWrapper] library
     */
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}
