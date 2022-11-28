package com.app.daggerapp

import android.util.Log
import javax.inject.Inject

private const val TAG = "EmailService"
class EmailService @Inject constructor() {
    
    fun sendEmail(to :String , from :String , body :String) {
        Log.d(Constants.APP_TAG, "sendEmail: Email sent Successfull!!")
    }

}