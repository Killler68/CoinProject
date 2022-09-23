package com.example.coinproject.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.coinproject.R

fun AppCompatActivity.navigateToFragmentActivity(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit()
}