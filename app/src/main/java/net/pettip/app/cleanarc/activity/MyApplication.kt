package net.pettip.app.cleanarc.activity

import android.app.Application
import android.content.SharedPreferences
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.HiltAndroidApp
import net.pettip.app.data.local.SharedPreferencesHelper

/**
 * @Project     : PetTip-Android
 * @FileName    : MyApplication
 * @Date        : 2024-11-26
 * @author      : CareBiz
 * @description : net.pettip.app.cleanarc.activity
 * @see net.pettip.app.cleanarc.activity.MyApplication
 */
@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any libraries or components here
        SharedPreferencesHelper.init(this)
    }
}