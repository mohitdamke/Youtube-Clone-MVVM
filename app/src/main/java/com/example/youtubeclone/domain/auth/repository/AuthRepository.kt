package com.example.youtubeclone.domain.auth.repository

import com.example.youtubeclone.util.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun signOutUser(): Flow<Resource<Unit>>
}