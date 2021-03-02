package com.dft.onyx50demo.matching

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferencesAuthStore(
        private val context: Context,
) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE
    )


    var voterId: String?
        get() = sharedPreferences.getString(KEY_VOTER_ID, "")
        set(value) {
            sharedPreferences.edit {
                putString(KEY_VOTER_ID, value)

            }
        }


    var handFingerString: String?
        get() = sharedPreferences.getString(KEY_HAND_FINGER_STRING, "")
        set(value) {
            sharedPreferences.edit {
                putString(KEY_HAND_FINGER_STRING, value)

            }
        }


    companion object {
        private const val SHARED_PREFERENCE_NAME = "OnyxSharedPreferences"
        private const val KEY_VOTER_ID = "keyVoterId"
        private const val KEY_HAND_FINGER_STRING = "keyHandFingerString"

    }
}