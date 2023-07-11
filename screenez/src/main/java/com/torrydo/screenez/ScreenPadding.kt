package com.torrydo.screenez

import androidx.core.graphics.Insets

data class ScreenPadding(
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int
) {
    companion object {

        @JvmStatic
        val None get() = ScreenPadding(0, 0, 0, 0)

        internal fun fromInsets(insets: Insets): ScreenPadding {
            return ScreenPadding(insets.left, insets.top, insets.right, insets.bottom)
        }
    }
}