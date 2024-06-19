package com.example.youtubeclone.presentation.screens.auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.youtubeclone.navigation.nestednavigation.NestedScreens
import kotlinx.coroutines.launch

import com.example.youtubeclone.presentation.viewmodel.auth.SignInViewModel


@Composable
fun SignIn(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel(),
    navController: NavController
) {

    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    val context = LocalContext.current

    val state = viewModel.signInState.collectAsState(initial = null)

    val focusManager = LocalFocusManager.current



    Column(
        modifier
            .fillMaxSize()
            .padding(30.dp), Arrangement.Center, Alignment.CenterHorizontally
    ) {

        Text(text = "SignIn", modifier = Modifier.padding(bottom = 30.dp), fontSize = 30.sp)
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(value = email, onValueChange = { email = it },
            label = { Text(text = "Email") }, singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(value = password, onValueChange = { password = it },
            label = { Text(text = "Password") }, singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            scope.launch {
                viewModel.loginUser(email, password)
            }
        }) {
            Text(text = "SignIn")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "or")
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(NestedScreens.SignUpScreen.route)
        }) {
            Text(text = "SignUp")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {

            if (state.value?.isLoading == true) {
                CircularProgressIndicator()
            }

            LaunchedEffect(key1 = state.value?.isSuccess) {
                scope.launch {
                    if (state.value?.isSuccess?.isNotEmpty() == true) {
//                        val success = state.value?.isSuccess
                        navController.navigate(NestedScreens.HomeScreen.route){
                            popUpTo(navController.graph.startDestinationId){
                                inclusive = true
                            }
                        }
                    }
                }
            }
            LaunchedEffect(key1 = state.value?.isError) {
                scope.launch {
                    if (state.value?.isError?.isNotEmpty() == true) {
                        val error = state.value?.isError
                        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}