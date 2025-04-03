package com.example.thuchanhapi.login

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
