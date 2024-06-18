package com.example.youtubeclone.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star

sealed class NavItem {
    object Home :
        Item(path = NavPath.HOME.toString(), title = NavTitle.HOME, icon = Icons.Default.Home)

    object Shorts :
        Item(
            path = NavPath.SHORTS.toString(),
            title = NavTitle.SHORTS,
            icon = Icons.Default.PlayArrow
        )

    object AddVideo :
        Item(
            path = NavPath.ADDVIDEO.toString(),
            title = NavTitle.ADDVIDEO,
            icon = Icons.Default.AddCircle
        )

    object Subscriptions :
        Item(
            path = NavPath.SUBSCRIPTIONS.toString(),
            title = NavTitle.SUBSCRIPTIONS,
            icon = Icons.Default.Star
        )

    object Profile :
        Item(
            path = NavPath.PROFILE.toString(), title = NavTitle.PROFILE, icon = Icons.Default.Person
        )
}