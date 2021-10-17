package com.simdamsi.trehigo.utils.onesignal

import android.app.Application
import android.content.Intent
import com.onesignal.OSNotificationOpenedResult
import com.onesignal.OneSignal
import com.simdamsi.trehigo.ui.activities.main.MainActivity
import com.simdamsi.trehigo.utils.Constants
import timber.log.Timber

class MyNotificationOpenedHandler(private val application: Application) :
    OneSignal.OSNotificationOpenedHandler {
    override fun notificationOpened(result: OSNotificationOpenedResult) {
        Timber.d("notificationOpened")
        Timber.i(
            "result.getNotification().getRawPayload(): %s",
            result.notification.rawPayload
        )

        // Pending intent
        val intent = Intent(application.applicationContext, MainActivity::class.java)
        intent.putExtra(
            Constants.INTENT_EXTRA_TARGET_KEY,
            Constants.INTENT_EXTRA_TARGET_VAL_NOTIFICATIONS
        )
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK
        application.startActivity(intent)
    }
}
