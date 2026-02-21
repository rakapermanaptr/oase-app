package com.rakapermanaptr.base.utils

import android.util.Log

actual object AppLogger {
    actual fun d(tag: String, message: String) {
        Log.d("TEST_DEBUG - $tag", message)
    }
}