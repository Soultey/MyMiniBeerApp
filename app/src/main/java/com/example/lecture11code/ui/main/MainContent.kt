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

data class NavItem(val icon: ImageVector, val route: String)

enum class Screen(val route: String) {
    HOME("home"),
    RANDOM("random"),
    SEARCH("search")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(artState: ArtState) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            MyBottomNavBar(navController = navController)
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screen.HOME.route,
            builder = {
                composable("home") {
                    Home(navController)
                }
                composable("random") {
                    Random(artState)
                }
                composable("search") {
                    Search()
                }
            }
        )
    }

}