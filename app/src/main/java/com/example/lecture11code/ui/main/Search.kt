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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
fun Search(){
    ComponentPlacement()
}


@Composable
fun ComponentPlacement() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 45.dp)
    ) {
        Column {
            Text(
                text = "Search Breweries",
                style = TextStyle(fontSize = 24.sp) // Set the desired font size
            )
        }

        Column {
            SearchBar()
        }

        Column{
            ResultCards(count = 4)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {

    var value by remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = {
            value = it
        },
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        shape = MaterialTheme.shapes.small, // Use small rounded shape
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFFBE29E),
        )
    )
}

@Composable
fun ResultCards(count: Int) {
    LazyColumn {
        items(count) { index ->
            BreweryCard(index = index)
        }
    }
}

@Composable
fun BreweryCard(index: Int) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .padding(12.dp)
            .clickable { /* Handle card click */ }
            .height(90.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF7D451B),
        )
    ) {
        // You can customize the content inside the card here
        Image(
            painter = painterResource(id = R.drawable.brewerypane),
            contentDescription = "Brewery Image $index",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .alpha(0.3f)
        )
    }
}