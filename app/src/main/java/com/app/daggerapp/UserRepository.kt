package com.app.daggerapp

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRepository"
class UserRepository @Inject constructor() {

    fun saveUser(email :String , password :String) {
        Log.d(Constants.APP_TAG, "saveUser: user email & password save successfully!!")
    }

}