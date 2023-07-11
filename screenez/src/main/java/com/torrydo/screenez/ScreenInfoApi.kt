package com.torrydo.screenez

import android.util.Size

internal interface ScreenInfoApi {

    fun screenSize(): Size

    fun orientation(): Int

    fun screenRotation(): ScreenRotation

    fun statusPadding(): ScreenPadding

    fun navBarPadding(): ScreenPadding

    fun cutoutPadding(): ScreenPadding

    fun isButtonsNavigation(): Boolean
    fun isGestureNavigation(): Boolean

    fun navBarHeight(): Int
    fun statusBarHeight(): Int

}