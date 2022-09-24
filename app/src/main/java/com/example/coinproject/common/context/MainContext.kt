package com.example.coinproject.common.context

import android.content.Context
import com.example.coinproject.common.application.AppComponent
import com.example.coinproject.common.application.MainApp

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }