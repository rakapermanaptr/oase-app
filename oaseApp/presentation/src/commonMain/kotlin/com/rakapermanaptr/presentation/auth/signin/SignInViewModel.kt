package com.rakapermanaptr.presentation.auth.signin

import androidx.lifecycle.viewModelScope
import com.rakapermanaptr.base.BaseViewModel
import com.rakapermanaptr.base.utils.AppLogger
import com.rakapermanaptr.base.utils.handleSupabaseError
import com.rakapermanaptr.domain.auth.signin.usecase.PostSignInUseCase
import kotlinx.coroutines.launch

class SignInViewModel(
    private val postSignInUseCase: PostSignInUseCase
): BaseViewModel<SignInViewEvent, SignInViewState, SignInViewEffect>(
    initialState = SignInViewState()
) {

    override suspend fun handleEvent(event: SignInViewEvent) {
        when (event) {
            is SignInViewEvent.OnUpdateEmail -> updateEmail(email = event.email)
            is SignInViewEvent.OnUpdatePassword -> updatePassword(password = event.password)
            is SignInViewEvent.OnButtonSignInClicked -> signIn(email = event.email, password = event.password)
        }
    }

    private fun updateEmail(email: String) {
        setState { copy(email = email) }
    }

    private fun updatePassword(password: String) {
        setState { copy(password = password) }
    }

    private fun signIn(email: String, password: String) {
        viewModelScope.launch {
            postSignInUseCase(email, password)
                .onSuccess {
                    AppLogger.d("SignInViewModel", "onSuccess")
                }
                .onFailure {
                    AppLogger.d("SignInViewModel", "onFailure: ${handleSupabaseError(it)}")
                }
        }
    }
}