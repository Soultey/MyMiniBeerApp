package com.example.lecture11code.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Data class to represent each item in the bottom navigation bar
data class NavItem(val icon: ImageVector, val route: String)

// Enum class representing the available screens/routes in the app
enum class Screen(val route: String) {
    HOME("home"),
    RANDOM("random"),
    SEARCH("search")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(breweryState: BreweryState) {

    // Create a NavController to handle navigation within the app
    val navController = rememberNavController()

    // Scaffold composable provides a basic layout structure for the screen
    Scaffold(
        bottomBar = {
            // Display the custom bottom navigation bar
            MyBottomNavBar(navController = navController)
        }
    ) {
        // NavHost manages the navigation between different screens
        NavHost(
            modifier = Modifier.padding(it), // Set padding for the NavHost
            navController = navController,
            startDestination = Screen.HOME.route, // Set the initial screen as HOME
            builder = {
                // Define composable functions for each screen route
                composable("home") {
                    Home(navController)
                }
                composable("random") {
                    Random(breweryState)
                }
                composable("search") {
                    Search()
                }
            }
        )
    }
}
