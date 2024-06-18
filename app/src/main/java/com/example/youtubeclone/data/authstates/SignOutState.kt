package com.example.youtubeclone.data.authstates

data class SignOutState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = "",
)