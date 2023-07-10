package com.torrydo.screenez

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.util.Size
import android.view.WindowInsets
import android.view.WindowManager
import android.view.WindowMetrics
import androidx.annotation.RequiresApi
import androidx.window.layout.WindowMetricsCalculator


internal class ScreenInfo {

    val api: Api = when {
        Build.VERSION.SDK_INT >= AndroidVersions.`11` -> {      // android 11+
            ApiLevel30()
        }

        Build.VERSION.SDK_INT >= AndroidVersions.`6` -> {       // android 6 -> 11
            ApiLevel23()
        }

        else -> Api()                                           // android 5 -> 6
    }

    open class Api {
        // default api level 21 to 23 (actually <23, haven't tried <21)
        open fun getScreenSize(context: Context): Size {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            return Size(display.width, display.height)
        }

        open fun getOrientation(context: Context): Int{
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay


            return -1
        }
    }

    // api level 30+ (android 11+)
    @RequiresApi(AndroidVersions.`11`)
    private class ApiLevel30 : Api() {
        override fun getScreenSize(context: Context): Size {
            val wm = context.getSystemService(WindowManager::class.java)
            val metrics: WindowMetrics = wm.currentWindowMetrics

//            val d = metrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
//            val cutouts = metrics.windowInsets.getInsets(WindowInsets.Type.displayCutout())
//
//
//            Log.d("<>", "1d: $d");
//            Log.d("<>", "1cutout: $cutouts");

            return Size(metrics.bounds.width(), metrics.bounds.height())
        }
    }

    // api level 23 to 29
    private class ApiLevel23 : Api() {
        @RequiresApi(AndroidVersions.`6`)
        override fun getScreenSize(context: Context): Size {

            val display = context.getSystemService(WindowManager::class.java).defaultDisplay
            val metrics = if (display != null) {
                DisplayMetrics().also { display.getRealMetrics(it) }
            } else {
                Resources.getSystem().displayMetrics
            }

            return Size(metrics.widthPixels, metrics.heightPixels)
        }
    }

}