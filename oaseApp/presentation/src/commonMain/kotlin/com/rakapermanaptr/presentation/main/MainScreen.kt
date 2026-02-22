package com.rakapermanaptr.presentation.main

import ExploreRoute
import HavenDetailsRoute
import HavenRoute
import HomeRoute
import ProfileRoute
import SignInRoute
import SignUpRoute
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.rakapermanaptr.presentation.auth.signin.SignInScreen
import com.rakapermanaptr.presentation.auth.signup.SignUpScreen
import com.rakapermanaptr.presentation.explore.ExploreScreen
import com.rakapermanaptr.presentation.haven.HavenScreen
import com.rakapermanaptr.presentation.haven.details.HavenDetailsScreen
import com.rakapermanaptr.presentation.home.HomeScreen
import com.rakapermanaptr.presentation.profile.ProfileScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showBottomBar = bottomNavItems.any { item ->
        currentDestination?.hasRoute(item.route::class) == true
    }
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    bottomNavItems.forEach { item ->
                        val isSelected = currentDestination?.hasRoute(item.route::class) == true

                        NavigationBarItem(
                            icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                            label = { Text(text = item.title) },
                            selected = isSelected,
                            onClick = {
                                navController.navigate(item.route) { // Navigasi via Object
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HavenRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<HavenRoute> {
                HavenScreen(
                    onNavigateToHavenDetails = { id ->
                        navController.navigate(HavenDetailsRoute(roomId = id))
                    }
                )
            }

            composable<HomeRoute> { HomeScreen() }
            composable<ExploreRoute> { ExploreScreen() }
            composable<ProfileRoute> { ProfileScreen() }

            composable<SignInRoute> {
                SignInScreen(
                    onNavigateToMain = {
                        navController.navigate(HomeRoute) {
                            popUpTo<SignInRoute> { inclusive = true }
                        }
                    },
                    onNavigateToSignUp = {
                        navController.navigate(SignUpRoute)
                    }
                )
            }

            composable<SignUpRoute> { SignUpScreen() }

            composable<HavenDetailsRoute> { backStackEntry ->
                val details = backStackEntry.toRoute<HavenDetailsRoute>()
                HavenDetailsScreen(roomId = details.roomId)
            }
        }
    }
}

data class BottomNavItem<T : Any>(
    val route: T,
    val title: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(HavenRoute, "Haven", Icons.Default.Home),
    BottomNavItem(ExploreRoute, "Explore", Icons.Default.TravelExplore),
    BottomNavItem(ProfileRoute, "Profile", Icons.Default.Person)
)