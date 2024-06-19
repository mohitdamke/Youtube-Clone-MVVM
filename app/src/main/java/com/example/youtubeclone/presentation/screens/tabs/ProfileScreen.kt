package com.example.youtubeclone.presentation.screens.tabs

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.youtubeclone.R
import com.example.youtubeclone.navigation.nestednavigation.NestedScreens
import com.example.youtubeclone.presentation.navigationbar.BottomNavigationBar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(navController: NavController) {

    val firebase = FirebaseAuth.getInstance()
    val currentUser = firebase.currentUser
    val openDialog = remember { mutableStateOf(false) }



    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LaunchedEffect(key1 = currentUser) {
                currentUser?.let {
                    if (currentUser.uid.isEmpty()) {
                        navController.navigate(NestedScreens.SignInScreen.route)
                    } else {
                        Log.d("TAG", "currentUser: $currentUser")
                    }
                }
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(id = R.string.profile),
                    style = typography.titleLarge,
                    color = Color.Black
                )

                Button(onClick = { openDialog.value = true }) {
                    Text(text = "SignOut")
                }
                if (openDialog.value) {
                    LogOutAlert(openDialog, firebase, navController)
                }
            }
        }
    }
}


@Composable
fun LogOutAlert(
    openDialog: MutableState<Boolean>,
    firebase: FirebaseAuth,
    navController: NavController
) {
    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        title = {
            Text(text = "Do you want to sign out?")
        },
        text = {
            Text("Click Yes to sign out and No to continue")
        },
        confirmButton = {
            Button(
                onClick = {
                    firebase.signOut()
                    openDialog.value = false
                    navController.navigate(NestedScreens.SignInScreen.route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }
            ) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("No")
            }
        }
    )
}