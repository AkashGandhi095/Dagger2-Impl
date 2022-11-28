package com.app.daggerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.inject.Inject

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var emailService :EmailService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manualDependency()

        withConstructorInjectionDagger()
        withFieldInjectionDagger()

    }

    private fun manualDependency() {
        // this manual dependency
        val userRepo = UserRepository()
        val emailService = EmailService()
        val userRegistrationService = UserRegistrationService(userRepo , emailService)
        userRegistrationService.registerUser("Jimmy@gmail.com" , "54322121#121")

    }

    private fun withConstructorInjectionDagger() {
        val component = DaggerUserRegistrationComponent.create()
        val registerService = component.getUserRegistrationService()
        registerService.registerUser("test@gmail.com" , "12312")

        val emailService = component.useEmailService()
        emailService.sendEmail("test@gmail.com" , "abc@email.com" , "hello")
    }

    private fun withFieldInjectionDagger() {
       DaggerUserRegistrationComponent.create()
           .inject(this)

        userRegistrationService.registerUser("Jimmy@gmail.com" , "54322121#121")
        emailService.sendEmail("" , "" , "")
    }


}