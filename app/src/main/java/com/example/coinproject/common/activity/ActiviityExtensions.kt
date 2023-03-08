package com.example.coinproject.common.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.coinproject.R
import com.example.coinproject.common.context.appComponent

fun AppCompatActivity.navigateToFragmentActivity(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.container_main, fragment)
        .commit()
}
fun Activity.getViewModelFactory() =
    applicationContext.appComponent.getViewModelFactory()