package com.example.lecture11code.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.lecture11code.R

@Composable
fun Search() {
    ComponentPlacement()
}

@Composable
fun ComponentPlacement() {
    Column(
        verticalArrangement = Arrangement.spacedBy(35.dp), // Space between columns
        horizontalAlignment = Alignment.CenterHorizontally, // Center items horizontally
        modifier = Modifier
            .fillMaxWidth() // Occupy maximum width
            .padding(top = 45.dp) // Add top padding
    ) {
        Column {
            Text(
                text = "Search Breweries",
                style = TextStyle(fontSize = 24.sp) // Set font size for text
            )
        }

        Column {
            SearchBar() // Display search bar component
        }

        Column {
            ResultCards(count = 4) // Display result cards
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var value by remember { mutableStateOf("") } // State to hold text input
    TextField(
        value = value,
        onValueChange = {
            value = it
        },
        textStyle = TextStyle.Default.copy(fontSize = 15.sp), // Set font size for text input
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFFEFAFD), // Set container color for text field
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = ""
            )
        },
        modifier = Modifier
            .height(48.dp) // Set height for the text field
    )
}

@Composable
fun ResultCards(count: Int) {
    LazyColumn {
        items(count) {
            BreweryCard() // Display brewery cards based on count
        }
    }
}

@Composable
fun BreweryCard() {
    Card(
        modifier = Modifier
            .width(450.dp) // Set width for the card
            .padding(12.dp) // Add padding around the card
            .clickable { /* Handle card click */ } // Handle click action for the card
            .height(90.dp), // Set height for the card
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF976744), // Set container color for the card
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.brewerypane), // Set image for the card
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp) // Set height for the image
                .alpha(0.3f) // Set transparency for the image
        )
    }
}
