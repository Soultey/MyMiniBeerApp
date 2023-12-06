package com.example.lecture11code.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lecture11code.R

@Composable
fun Home(navController: NavController) {
    UIPlacement(navController)
}

@Composable
fun UIPlacement(navController: NavController) {
    Column {
        AppLogo()
        SearchBrewCardLabel()
        SearchBrewCard(navController)
        RandomBrewCardLabel()
        RandomBrewCard(navController)
    }
}

@Composable
fun AppLogo(){
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp) // Set the desired height for the logo
            .padding(top = 10.dp)
    )
}

@Composable
fun SearchBrewCardLabel(){
    Text(
        text = "Search Breweries",
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        style = TextStyle(
            fontWeight = FontWeight.Bold, // Set the text to bold
            fontSize = 15.sp // Set the desired font size
        )
    )
}

@Composable
fun SearchBrewCard(navController: NavController) {

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
        SearchBrewCardContent()
    }

}

@Composable
fun SearchBrewCardContent(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.searchbeer),
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f) // Maintain aspect ratio of the image
                .alpha(0.5f)
        )

        Text(
            text = "Search Breweries by Name, Type, Country, City, or State.",
            modifier = Modifier
                .padding(start= 200.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = Color(0xFF91572B), // Set text color

            )
        )
    }
}

@Composable
fun RandomBrewCardLabel(){
    Text(
        text = "Random Brewery",
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        style = TextStyle(
            fontWeight = FontWeight.Bold, // Set the text to bold
            fontSize = 15.sp // Set the desired font size
        )
    )
}

@Composable
fun RandomBrewCard(navController: NavController){

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
        RandomBrewCardContent()
    }
}

@Composable
fun RandomBrewCardContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.randombeer),
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f) // Maintain aspect ratio of the image
                .alpha(0.5f)
        )
        Text(
            text = "Find a Random Brewery Here.",
            modifier = Modifier
                .padding(start = 20.dp, end= 80.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color(0xFF91572B),
            )
        )
    }
}
