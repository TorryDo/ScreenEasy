package com.torrydo.screenez

import android.content.Context
import android.content.res.Configuration
import android.provider.Settings
import android.util.Log
import android.util.Size
import androidx.core.view.WindowInsetsCompat.Type
import androidx.window.core.ExperimentalWindowApi
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowMetricsCalculator
import java.lang.ref.WeakReference


object ScreenEz {

    private val screenInfo: ScreenInfo = ScreenInfo()

    private var screenSize: Size = Size(0, 0)


    private var _weakContext: WeakReference<Context>? = null
    private val context: Context
        get() {
            if (_weakContext == null) {
                throw IllegalStateException("You haven't call `ScreenEz.init(context)`")
            }
            return _weakContext!!.get()!!
        }

    @OptIn(ExperimentalWindowApi::class)
    fun setup(context: Context, listenOrientationChange: Boolean = true) {
        _weakContext = WeakReference(context.applicationContext)

        screenSize = screenInfo.api.getScreenSize(this.context)

//        val wit = WindowInfoTracker.getOrCreate(this.context)
//        val wmc = WindowMetricsCalculator.getOrCreate()
//
//        val maxWindowMetrics = wmc.computeMaximumWindowMetrics(this.context)
//
//        val maximumWM = maxWindowMetrics.bounds.flattenToString()
//
//        val insets = maxWindowMetrics.getWindowInsets().getInsets(Type.systemBars())
//
//        val cutouts = maxWindowMetrics.getWindowInsets().getInsets(Type.displayCutout())
//
//        Log.d("<>", "maximumWM: $maximumWM");
//        Log.d("<>", "insets: $insets");
//        Log.d("<>", "cutouts: $cutouts");

    }

    enum class Rotation {
        PORTRAIT,
        LANDSCAPE,
        REVERSED_PORTRAIT,
        REVERSED_LANDSCAPE,
        UNKNOWN
    }

    @JvmOverloads
    fun refresh(
        configuration: Configuration = this.context.resources.configuration
    ) {
        screenSize = screenInfo.api.getScreenSize(this.context)
    }

    fun isUsingGestureNavigation(): Boolean {
        val navBarMode: Int = Settings.Secure.getInt(
            this.context.contentResolver,
            "navigation_mode"
        )
        return navBarMode == 2 // 0: 3-button navigation, 2: gesture navigation
    }


    //region Public API ----------------------------------------------------------------------------

    val width get() = screenSize.width
    val height get() = screenSize.height

    val safeHeight: Int
        get() {
            return screenSize.height - softNavBarHeight - statusBarHeight
        }

    val safeWidth: Int
        get() {
            return screenSize.width
        }

    /**
     * portrait: normal ok
     * */
    val statusBarHeight: Int
        get() {
            val statusBarHeightId = getIdentifier("status_bar_height", "dimen", "android")
            return context.resources.getDimensionPixelSize(statusBarHeightId)
        }

    /**
     * portrait: 3 mode ok: 0 height, line, 3 buttons
     * */
    val softNavBarHeight: Int
        get() {
            val resourceId = getIdentifier("navigation_bar_height", "dimen", "android")
            return context.resources.getDimensionPixelSize(resourceId)
        }


    //endregion ------------------------------------------------------------------------------------


    private fun getIdentifier(name: String, defType: String, defPackage: String): Int {
        return context.resources.getIdentifier(name, defType, defPackage)
    }

}