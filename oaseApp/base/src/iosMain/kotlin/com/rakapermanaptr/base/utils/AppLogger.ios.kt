package com.rakapermanaptr.base.utils

import platform.Foundation.NSLog

actual object AppLogger {
    actual fun d(tag: String, message: String) {
        NSLog("TEST_DEBUG - $tag : $message")
    }
}