package com.example.lecture11code.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MyBottomNavBar(navController: NavController) {
    val navItems = listOf(
        NavItem(Icons.Rounded.Home, Screen.HOME.route),
        NavItem(Icons.Rounded.Add, Screen.RANDOM.route),
        NavItem(Icons.Rounded.Search, Screen.SEARCH.route)
    )

    NavigationBar(
        containerColor = Color(0xFFFACB40).copy(alpha = 0.5f)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach {
            NavigationBarItem(
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route)
                },
                icon = {
                    Icon(it.icon, contentDescription = null)
                }
            )
        }
    }
}