package com.example.youtubeclone.presentation.screens.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.youtubeclone.R
import com.example.youtubeclone.navigation.nestednavigation.NestedScreens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {

    val coroutineScope = rememberCoroutineScope()
    val firebase = FirebaseAuth.getInstance()
    val currentUser = firebase.currentUser


    LaunchedEffect(currentUser) {
        coroutineScope.launch {

            if (currentUser == null && currentUser?.uid == null) {
                navController.navigate(NestedScreens.SignInScreen.route) {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }

                }
            } else {
                navController.navigate(NestedScreens.HomeScreen.route) {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }
        }

        delay(1000)
        navController.navigate(NestedScreens.HomeScreen.route)
    }



    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.youtube_logo),
            contentDescription = null,
            modifier = modifier.size(150.dp)
        )

    }
}