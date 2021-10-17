package com.simdamsi.trehigo

import android.app.Application
import com.onesignal.OneSignal
import com.simdamsi.trehigo.utils.onesignal.MyNotificationOpenedHandler
import com.simdamsi.trehigo.utils.onesignal.MyNotificationWillShowInForegroundHandler
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    companion object {
        private const val ONESIGNAL_APP_ID = "" // TODO obtain onesignal app id
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.setNotificationWillShowInForegroundHandler(
            MyNotificationWillShowInForegroundHandler(this)
        )
        OneSignal.unsubscribeWhenNotificationsAreDisabled(true)
        OneSignal.setNotificationOpenedHandler(MyNotificationOpenedHandler(this))
    }
}
