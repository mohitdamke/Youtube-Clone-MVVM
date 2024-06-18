package com.example.youtubeclone.navigation.nestednavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.youtubeclone.presentation.screens.auth.SignIn
import com.example.youtubeclone.presentation.screens.auth.SignUp
import com.example.youtubeclone.presentation.screens.loading.LoadingScreen
import com.example.youtubeclone.presentation.screens.tabs.AddVideoScreen
import com.example.youtubeclone.presentation.screens.tabs.HomeScreen
import com.example.youtubeclone.presentation.screens.tabs.ProfileScreen
import com.example.youtubeclone.presentation.screens.tabs.ShortsScreen
import com.example.youtubeclone.presentation.screens.tabs.SubscriptionsScreen

@Composable
fun NestedNavigationScreen() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = NestedScreens.LoadingPage.route) {

        composable(NestedScreens.LoadingPage.route) {
            LoadingScreen(navController = navHostController)
        }

        composable(NestedScreens.SignInScreen.route) {
            SignIn(navController = navHostController)
        }

        composable(NestedScreens.SignUpScreen.route) {
            SignUp(navController = navHostController)
        }

        composable(NestedScreens.HomeScreen.route) {
            HomeScreen(navController = navHostController)
        }
        composable(NestedScreens.ShortsScreen.route) {
            ShortsScreen(navController = navHostController)
        }
        composable(NestedScreens.AddVideoScreen.route) {
            AddVideoScreen(navController = navHostController)
        }
        composable(NestedScreens.SubscriptionsScreen.route) {
            SubscriptionsScreen(navController = navHostController)
        }
        composable(NestedScreens.ProfileScreen.route) {
            ProfileScreen(navController = navHostController)

        }
    }
}