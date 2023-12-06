package com.example.lecture11code.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lecture11code.R

@Composable
fun Home(navController: NavController) {
    NavigationButton(navController)
}

@Composable
fun NavigationButton(navController: NavController) {


    Column {
        // Your logo image here
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp) // Set the desired height for the logo
                .padding(top = 10.dp)
        )
        Text(
            text = "Search Breweries",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clickable {
                    navController.navigate("search")
                }
                .height(220.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFBE29E),
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.searchbeer),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
        }

        Text(
            text = "Random Brewery",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clickable {
                    navController.navigate("random")
                }
                .height(220.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFBE29E),
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.randombeer),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
        }
    }
}
