package com.torrydo.screenez

import android.content.Context


object ScreenEz {

    private val screenEasy = ScreenEasy()

    @JvmStatic
    fun with(context: Context) {
        screenEasy.with(context)
    }

    @JvmStatic
    fun refresh() = screenEasy.refresh()

    @JvmStatic
    val navBarPadding: ScreenPadding get() = screenEasy.navBarPadding

    @JvmStatic
    val statusBarPadding: ScreenPadding get() = screenEasy.statusBarPadding

    @JvmStatic
    val cutoutPadding: ScreenPadding get() = screenEasy.cutoutPadding

    @JvmStatic
    val fullWidth get() = screenEasy.fullWidth

    @JvmStatic
    val fullHeight get() = screenEasy.fullHeight

    @JvmStatic
    val fullSize get() = screenEasy.fullSize

    @JvmStatic
    val safeArea get() = screenEasy.safeArea

    @JvmStatic
    val safeScreenPadding get() = screenEasy.safeScreenPadding

    @JvmStatic
    val safePaddingLeft get() = screenEasy.safePaddingLeft

    @JvmStatic
    val safePaddingRight get() = screenEasy.safePaddingRight

    @JvmStatic
    val safePaddingTop get() = screenEasy.safePaddingTop

    @JvmStatic
    val safePaddingBottom get() = screenEasy.safePaddingBottom

    @JvmStatic
    val safeWidth get() = screenEasy.safeWidth

    @JvmStatic
    val safeHeight get() = screenEasy.safeHeight

    @JvmStatic
    val safeSize get() = screenEasy.safeSize

    @JvmStatic
    val statusBarHeight get() = screenEasy.statusBarHeight

    @JvmStatic
    val navBarHeight get() = screenEasy.navBarHeight

    @JvmStatic
    val screenRotation get() = screenEasy.screenRotation

    // fun

    @JvmStatic
    fun isPortrait() = screenEasy.isPortrait()

    @JvmStatic
    fun isButtonsNavigation() = screenEasy.isButtonsNavigation()

    @JvmStatic
    fun isGestureNavigation() = screenEasy.isGestureNavigation()


}