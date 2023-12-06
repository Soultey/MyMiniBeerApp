package com.example.lecture11code.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

// Composable function to create a custom bottom navigation bar
@Composable
fun MyBottomNavBar(navController: NavController) {
    // Define navigation items with icons and corresponding routes
    val navItems = listOf(
        NavItem(Icons.Rounded.Home, Screen.HOME.route),
        NavItem(Icons.Rounded.Add, Screen.RANDOM.route),
        NavItem(Icons.Rounded.List, Screen.SEARCH.route)
    )

    // Create a NavigationBar component for the bottom navigation
    NavigationBar(
        containerColor = Color(0xFFFACB40).copy(alpha = 0.5f) // Set container color with alpha
    ) {
        // Get the current route from the NavController's back stack
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        // Iterate through each navigation item and create a NavigationBarItem
        navItems.forEach {
            NavigationBarItem(
                selected = currentRoute == it.route, // Check if the item is currently selected
                onClick = {
                    navController.navigate(it.route) // Navigate to the item's route on click
                },
                icon = {
                    Icon(it.icon, contentDescription = null) // Display the item's icon
                }
            )
        }
    }
}
