package com.simdamsi.trehigo.utils

import android.content.Context
import android.content.SharedPreferences
import com.simdamsi.trehigo.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPref @Inject constructor(
    @ApplicationContext context: Context
) {
    companion object {
        private const val PREF_TOKEN = "token"
        private const val PREF_USER = "user"
    }

    private val context: Context = context.applicationContext

    @Volatile
    private var sharedPref: SharedPreferences? = null

    @Volatile
    // TODO crate User in .models
    private var user /*:User?*/ = null

    private fun getSharedPerf(): SharedPreferences {
        return sharedPref ?: synchronized(this) {
            context.getSharedPreferences(
                "${BuildConfig.APPLICATION_ID}.main",
                Context.MODE_PRIVATE
            )
        }
    }

    fun reset() {
        getSharedPerf().edit().clear().apply()

/*        user = null*/
    }

    // ----------------------------------------------------------------

    fun setToken(token: String) {
        getSharedPerf()
            .edit()
            .apply {
                putString(PREF_TOKEN, token)
                apply()
            }
    }

    fun getToken(): String? {
        return getSharedPerf().getString(PREF_TOKEN, null)
    }

    /*fun setUser(user: User) {
        getSharedPerf()
            .edit()
            .apply {
                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi.adapter(User::class.java)

                putString(PREF_USER, jsonAdapter.toJson(user))
                apply()
            }
    }*/

   /* fun getUser(): User? {
        return user ?: synchronized(this) {
            getSharedPerf()
                .let {
                    val moshi = Moshi.Builder().build()
                    val jsonAdapter = moshi.adapter(User::class.java)

                    val userJson = it.getString(PREF_USER, null)

                    user = if (userJson == null) {
                        null
                    } else {
                        jsonAdapter.fromJson(userJson)
                    }

                    Timber.d("user: $user")

                    user
                }
        }
    }*/

    // ----------------------------------------------------------------

    fun isUserLoggedIn(): Boolean {
        return false
        /*    return getUser() != null*/
    }
}
