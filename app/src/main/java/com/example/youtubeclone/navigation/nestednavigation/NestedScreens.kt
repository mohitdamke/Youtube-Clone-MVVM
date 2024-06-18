package com.example.youtubeclone.navigation.nestednavigation

import com.example.youtubeclone.bottomnav.NavItem

sealed class NestedScreens(val route: String) {

    object LoadingPage : NestedScreens(route = "Loading_Screen")

        object SignInScreen : NestedScreens(route = "SignIn_Screen")
        object SignUpScreen : NestedScreens(route = "SignUp_Screen")

        object ShortsScreen : NestedScreens(route = NavItem.Shorts.path)
        object HomeScreen : NestedScreens(route = NavItem.Home.path)
        object AddVideoScreen : NestedScreens(route = NavItem.AddVideo.path)
        object SubscriptionsScreen : NestedScreens(route = NavItem.Subscriptions.path)
        object ProfileScreen : NestedScreens(route = NavItem.Profile.path)

    }

