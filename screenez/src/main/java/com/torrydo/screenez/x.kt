package com.torrydo.screenez

internal fun ScreenPadding.total() = left + top + right + bottom
internal fun ScreenPadding.width() = left + right
internal fun ScreenPadding.height() = top + bottom