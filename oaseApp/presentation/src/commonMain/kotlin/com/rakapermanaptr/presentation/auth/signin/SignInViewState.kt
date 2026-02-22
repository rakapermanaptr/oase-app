package com.rakapermanaptr.presentation.auth.signin

import com.rakapermanaptr.base.UiEffect
import com.rakapermanaptr.base.UiEvent
import com.rakapermanaptr.base.UiState

sealed class SignInViewEvent : UiEvent {
    data class OnUpdateEmail(val email: String): SignInViewEvent()
    data class OnUpdatePassword(val password: String): SignInViewEvent()
    data class OnButtonSignInClicked(val email: String, val password: String): SignInViewEvent()
}

data class SignInViewState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = ""
) : UiState

sealed class SignInViewEffect : UiEffect {

}