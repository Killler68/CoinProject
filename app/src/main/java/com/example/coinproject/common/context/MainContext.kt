package com.example.coinproject.common.context

import android.content.Context
import android.widget.Toast
import androidx.annotation.Nullable
import com.example.coinproject.common.application.AppComponent
import com.example.coinproject.common.application.MainApp
import org.jetbrains.annotations.NotNull

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }

fun Context?.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
