package com.android.lostankit7.util

import android.content.Context
import java.util.prefs.Preferences

/*
class UserPreferences(context: Context) {

    private val appContext = context.applicationContext
    private val dataStore = appContext.createDataStore("app_prefs")



    private suspend fun setValue(k: Preferences.Key<String>, v: String) {
        dataStore.edit { pref ->
            pref[k] = v
        }
    }

    private fun getValue(k: Preferences.Key<String>): Flow<String?> {
        //returns value to be observed as live data
        return dataStore.data.map { prefs ->
            prefs[k]
        }
    }

    companion object {
        private val EMAIL = stringPreferencesKey("google_email")
        private val USERNAME = stringPreferencesKey("google_username")
    }

}
 */