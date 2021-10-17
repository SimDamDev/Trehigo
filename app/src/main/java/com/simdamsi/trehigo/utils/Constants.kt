package com.simdamsi.trehigo.utils

import com.simdamsi.trehigo.BuildConfig

object Constants {
    /**
     * Server endpoint without end slash.
     */
    const val SERVER_ENDPOINT = "http://jsonplaceholder.typicode.com"

    /**
     * For MyNotificationOpenedHandler
     */
    const val INTENT_EXTRA_TARGET_KEY = "target"
    const val INTENT_EXTRA_TARGET_VAL_NOTIFICATIONS = "notifications"

    /**
     * For Broadcast
     */
    const val BROADCAST_ACTION_NOTIFICATIONS = BuildConfig.APPLICATION_ID + ".notifications"
}
