package com.repos.fragment

import android.support.v4.app.Fragment
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.repos.view.setTouchable

/**
 * @author Gabriel Rodriguez
 * @version 1.0
 */

open class BaseAnimateFragment : Fragment() {

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        if (nextAnim == 0) {
            return super.onCreateAnimation(transit, enter, nextAnim)
        } else {
            val animation = AnimationUtils.loadAnimation(activity, nextAnim)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationEnd(animation: Animation?) {
                    activity.window.setTouchable()
                }

                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }
            })
            return animation
        }
    }
}