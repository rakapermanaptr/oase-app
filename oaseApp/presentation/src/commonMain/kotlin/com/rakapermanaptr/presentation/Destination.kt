package com.rakapermanaptr.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val route: String
    val title: String
    val icon: ImageVector?
}

object HomeDestination : Destination {
    override val route: String = "home_screen"
    override val title: String = "Home"
    override val icon: ImageVector = Icons.Default.Home
}

object ExploreDestination : Destination {
    override val route: String = "explore_screen"
    override val title: String = "Explore"
    override val icon: ImageVector = Icons.Default.TravelExplore
}

object ProfileDestination : Destination {
    override val route: String = "profile_screen"
    override val title: String = "Profile"
    override val icon: ImageVector = Icons.Default.Person
}

data object SignInDestination : Destination {
    override val route: String = "sign_in_screen"
    override val title: String = "Sign In"
    override val icon: ImageVector? = null
}

data object SignUpDestination : Destination {
    override val route: String = "sign_up_screen"
    override val title: String = "Sign Up"
    override val icon: ImageVector? = null
}