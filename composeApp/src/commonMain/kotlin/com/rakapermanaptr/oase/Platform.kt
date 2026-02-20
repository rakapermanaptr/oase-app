package com.rakapermanaptr.oase

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform