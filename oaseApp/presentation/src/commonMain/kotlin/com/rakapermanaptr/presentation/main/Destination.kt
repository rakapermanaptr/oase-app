package com.rakapermanaptr.presentation.main

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
    override val route: String = "route_screen"
    override val title: String = "Profile"
    override val icon: ImageVector = Icons.Default.Person
}