package com.example.youtubeclone.presentation.screens.tabs

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.youtubeclone.presentation.navigationbar.BottomNavigationBar
import com.example.youtubeclone.navigation.nestednavigation.NestedScreens
import com.example.youtubeclone.presentation.navigationbar.TopNavItems
import com.example.youtubeclone.presentation.viewmodel.auth.SignOutViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
//    viewModel: SignOutViewModel = hiltViewModel()
) {
//    val scope = rememberCoroutineScope()
//    val state = viewModel.signOutState.collectAsState(initial = null)
    val firebase = FirebaseAuth.getInstance()

//    LaunchedEffect(key1 = firebase.currentUser) {
//        scope.launch {
//            if (firebase.currentUser == null) {
//                navController.navigate(NestedScreens.SignInScreen.route) {
//                    popUpTo(NestedScreens.HomeScreen.route) { inclusive = true }
//                }
//            }
//        }
//    }

    Scaffold(topBar = {
        TopNavItems(navController = navController)
    },
        bottomBar = {
            BottomAppBar {
                BottomNavigationBar(navController = navController)
            }
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Main Page", fontSize = 30.sp, fontWeight = FontWeight.W700)

        }
    }
}


