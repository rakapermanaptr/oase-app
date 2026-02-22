package com.rakapermanaptr.presentation.auth.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.rakapermanaptr.design_system.OaseTextField
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = koinViewModel(),
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(text = "Sign In Screen")

            OaseTextField(
                value = state.email,
                onValueChange = {
                    viewModel.onEvent(SignInViewEvent.OnUpdateEmail(it))
                },
                label = "email",
                placeholder = "email@gmail.com",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OaseTextField(
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(SignInViewEvent.OnUpdatePassword(it))
                },
                label = "password",
                placeholder = "",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(
                onClick = {
                    viewModel.onEvent(
                        SignInViewEvent.OnButtonSignInClicked(
                            state.email,
                            state.password
                        )
                    )
                }
            ) {
                Text(text = "Login")
            }

            Button(
                onClick = {
                    onNavigateToSignUp()
                }
            ) {
                Text(text = "Register")
            }
        }
    }
}