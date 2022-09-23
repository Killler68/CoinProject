package com.example.coinproject.common.fragment

import androidx.fragment.app.Fragment
import com.example.coinproject.R

fun Fragment.navigateToFragment(fragment: Fragment) {
    this.parentFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}