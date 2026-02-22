package com.rakapermanaptr.presentation.auth.signup

import androidx.lifecycle.viewModelScope
import com.rakapermanaptr.base.BaseViewModel
import com.rakapermanaptr.base.utils.AppLogger
import com.rakapermanaptr.base.utils.handleSupabaseError
import com.rakapermanaptr.domain.auth.signup.usecase.PostSignUpUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val postSignUpUseCase: PostSignUpUseCase
) : BaseViewModel<SignUpViewEvent, SignUpViewState, SignUpViewEffect>(
    initialState = SignUpViewState()
) {

    override suspend fun handleEvent(event: SignUpViewEvent) {
        when (event) {
            is SignUpViewEvent.OnUpdateEmail -> updateEmail(email = event.email)
            is SignUpViewEvent.OnUpdateDisplayName -> updateDisplayName(displayName = event.displayName)
            is SignUpViewEvent.OnUpdatePassword -> updatePassword(password = event.password)
            is SignUpViewEvent.OnButtonSignUpClicked -> signUp(
                email = event.email,
                password = event.password,
                displayName = event.displayName
            )

        }
    }

    private fun updateEmail(email: String) {
        setState { copy(email = email) }
    }

    private fun updateDisplayName(displayName: String) {
        setState { copy(displayName = displayName) }
    }

    private fun updatePassword(password: String) {
        setState { copy(password = password) }
    }

    private fun signUp(email: String, password: String, displayName: String) {
        viewModelScope.launch {
            postSignUpUseCase(email, password, displayName)
                .onSuccess {
                    AppLogger.d("SignUp", "onSuccess")
                }
                .onFailure {
                    AppLogger.d("SignUp", "onFailure: ${handleSupabaseError(it)}")

                }
        }
    }
}