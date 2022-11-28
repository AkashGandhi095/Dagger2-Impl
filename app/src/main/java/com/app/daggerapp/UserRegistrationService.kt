package com.app.daggerapp

import android.util.Log
import javax.inject.Inject

private const val TAG = "UserRegistrationService"
class UserRegistrationService @Inject constructor (
    private val userRepo :UserRepository ,
    private val emailService: EmailService
    ) {

    fun registerUser(email :String , password :String) {
        Log.d(Constants.APP_TAG, "registerUser: ")
        userRepo.saveUser(email, password)
        emailService.sendEmail(email , "peterParker@gamil.com" , "You have registered to Our App!!")
    }

}