package com.example.youtubeclone.data.authstates

data class SignInState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = "",
)