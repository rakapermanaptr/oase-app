package com.rakapermanaptr.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rakapermanaptr.presentation.ExploreDestination
import com.rakapermanaptr.presentation.HomeDestination
import com.rakapermanaptr.presentation.ProfileDestination
import com.rakapermanaptr.presentation.SignInDestination
import com.rakapermanaptr.presentation.SignUpDestination
import com.rakapermanaptr.presentation.auth.signin.SignInScreen
import com.rakapermanaptr.presentation.auth.signup.SignUpScreen
import com.rakapermanaptr.presentation.explore.ExploreScreen
import com.rakapermanaptr.presentation.home.HomeScreen
import com.rakapermanaptr.presentation.profile.ProfileScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavItems = listOf(HomeDestination, ExploreDestination, ProfileDestination)
    val routesWithBottomBar = bottomNavItems.map { it.route }
    Scaffold(
        bottomBar = {
            if (currentRoute in routesWithBottomBar) {
                NavigationBar {
                    bottomNavItems.forEach { screen ->
                        NavigationBarItem(
                            icon = { Icon(imageVector = screen.icon!!, contentDescription = screen.title) },
                            label = { Text(text = screen.title) },
                            selected = currentRoute == screen.route,
                            onClick = {
                                navController.navigate(screen.route) {
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
            startDestination = SignInDestination.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(HomeDestination.route) { HomeScreen() }
            composable(ExploreDestination.route) { ExploreScreen() }
            composable(ProfileDestination.route) { ProfileScreen() }
            composable(SignInDestination.route) {
                SignInScreen(
                    onNavigateToMain = {
                        navController.navigate(HomeDestination.route) {
                            popUpTo(SignInDestination.route) { inclusive = true }
                        }
                    },
                    onNavigateToSignUp = {
                        navController.navigate(SignUpDestination.route)
                    }
                )
            }
            composable(SignUpDestination.route) { SignUpScreen() }
        }
    }
}