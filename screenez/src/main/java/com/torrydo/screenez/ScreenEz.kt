package com.torrydo.screenez

import android.content.Context


object ScreenEz {

    private val screenEz = ScreenEasy()

    @JvmStatic
    fun with(context: Context) {
        screenEz.with(context)
    }

    @JvmStatic
    fun refresh() = screenEz.refresh()

    @JvmStatic
    val navBarPadding: ScreenPadding get() = screenEz.navBarPadding

    @JvmStatic
    val statusBarPadding: ScreenPadding get() = screenEz.statusBarPadding

    @JvmStatic
    val cutoutPadding: ScreenPadding get() = screenEz.cutoutPadding

    @JvmStatic
    val fullWidth get() = screenEz.fullWidth

    @JvmStatic
    val fullHeight get() = screenEz.fullHeight

    @JvmStatic
    val fullSize get() = screenEz.fullSize

    @JvmStatic
    val safeArea get() = screenEz.safeArea

    @JvmStatic
    val safeScreenPadding get() = screenEz.safeScreenPadding

    @JvmStatic
    val safePaddingLeft get() = screenEz.safePaddingLeft

    @JvmStatic
    val safePaddingRight get() = screenEz.safePaddingRight

    @JvmStatic
    val safePaddingTop get() = screenEz.safePaddingTop

    @JvmStatic
    val safePaddingBottom get() = screenEz.safePaddingBottom

    @JvmStatic
    val safeWidth get() = screenEz.safeWidth

    @JvmStatic
    val safeHeight get() = screenEz.safeHeight

    @JvmStatic
    val safeSize get() = screenEz.safeSize

    @JvmStatic
    val statusBarHeight get() = screenEz.statusBarHeight

    @JvmStatic
    val navBarHeight get() = screenEz.navBarHeight

    @JvmStatic
    val screenRotation get() = screenEz.screenRotation

    // fun

    @JvmStatic
    fun isPortrait() = screenEz.isPortrait()

    @JvmStatic
    fun isButtonsNavigation() = screenEz.isButtonsNavigation()

    @JvmStatic
    fun isGestureNavigation() = screenEz.isGestureNavigation()


}