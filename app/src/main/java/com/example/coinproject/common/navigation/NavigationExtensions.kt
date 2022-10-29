package com.example.coinproject.common.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(@IdRes action: Int) {
    findNavController().navigate(action)
}