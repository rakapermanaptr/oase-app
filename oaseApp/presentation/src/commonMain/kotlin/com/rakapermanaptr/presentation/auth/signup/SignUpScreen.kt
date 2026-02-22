package com.rakapermanaptr.presentation.auth.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.rakapermanaptr.design_system.OaseTextField
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpScreen(viewModel: SignUpViewModel = koinViewModel()) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val state by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Sign Up Screen")

            OaseTextField(
                value = state.email,
                onValueChange = {
                    viewModel.onEvent(SignUpViewEvent.OnUpdateEmail(it))
                },
                label = "email",
                placeholder = "email@gmail.com",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OaseTextField(
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(SignUpViewEvent.OnUpdatePassword(it))
                },
                label = "password",
                placeholder = "",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onEvent(SignUpViewEvent.OnButtonSignUpClicked(state.email, state.password))
                }
            ) {
                Text(text = "Sign up")
            }

        }
    }
}