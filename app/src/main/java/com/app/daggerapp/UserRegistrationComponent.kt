package com.app.daggerapp

import dagger.Component

@Component
interface UserRegistrationComponent {
    fun inject(activity: MainActivity)
}