package com.mindorks.framework.mvp.util.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mindorks.framework.mvp.R

/**
 * Created by jyotidubey on 18/01/18.
 */
internal fun FragmentManager.removeFragment(tag: String,
                                            slideIn: Int = R.anim.slide_left,
                                            slideOut: Int = R.anim.slide_right) {
    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(this.findFragmentByTag(tag)!!)
            .commitNow()
}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String,
                                         slideIn: Int = R.anim.slide_left,
                                         slideOut: Int = R.anim.slide_right) {
    this.beginTransaction().disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .add(containerViewId, fragment, tag)
            .commit()
}

