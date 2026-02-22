package com.rakapermanaptr.presentation.auth.signup

import com.rakapermanaptr.base.UiEffect
import com.rakapermanaptr.base.UiEvent
import com.rakapermanaptr.base.UiState

sealed class SignUpViewEvent : UiEvent {
    data class OnUpdateEmail(val email: String) : SignUpViewEvent()
    data class OnUpdateDisplayName(val displayName: String) : SignUpViewEvent()
    data class OnUpdatePassword(val password: String) : SignUpViewEvent()
    data class OnButtonSignUpClicked(
        val email: String,
        val password: String,
        val displayName: String
    ) : SignUpViewEvent()
}

data class SignUpViewState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val displayName: String = ""
) : UiState

sealed class SignUpViewEffect : UiEffect {

}