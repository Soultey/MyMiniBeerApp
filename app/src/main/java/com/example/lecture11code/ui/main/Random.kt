package com.example.lecture11code.ui.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lecture11code.R
import com.example.lecture11code.data.Breweries
import kotlinx.coroutines.launch

@Composable
fun Random(artState: BreweryState){

    val currentArtIndex = remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        artState.getArtwork()
    }

    LazyColumn(
        modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .fillMaxSize(),
        content = {
            items(artState.breweryCollection.value.size) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    ShuffleButton(
                        onClick = {
                            artState.getArtwork()
                        },
                    ) {}

                    DisplayArtPiece(
                        artState.breweryCollection.value[currentArtIndex.intValue],
                    )

                }

            }
        })
}

@Composable
fun DisplayArtPiece(breweries: Breweries) {

    val (showAdditionalInfo, setShowAdditionalInfo) = remember { mutableStateOf(false) }

    var isIconRotated by remember { mutableStateOf(false) } // State to manage arrow icon rotation

    val nameTextSize =
        if (showAdditionalInfo) 50.sp else 20.sp // Change text size based on showAdditionalInfo

    val cityTextSize =
        if (showAdditionalInfo) 35.sp else 17.sp // Change text size based on showAdditionalInfo

    var imageResource by remember { mutableIntStateOf(R.drawable.brewerypane) } // Initial image resource


    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF7D451B),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .animateContentSize()
            .clickable { // Toggle visibility on card click
                setShowAdditionalInfo(!showAdditionalInfo)
                isIconRotated = !isIconRotated // Toggle icon rotation
                imageResource =
                    if (showAdditionalInfo) R.drawable.brewerypane else R.drawable.brewery

            }

    ) {
        CardContent(showAdditionalInfo, breweries, imageResource, nameTextSize, isIconRotated, cityTextSize)
    }
}


@Composable
fun CardContent(showAdditionalInfo: Boolean, breweries: Breweries, imageResource: Int, nameTextSize: TextUnit, isIconRotated: Boolean, cityTextSize: TextUnit ){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .alpha(0.3f)
        )

        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = breweries.name ?: "No name",
                    style = TextStyle(
                        fontSize = nameTextSize,
                        color = Color.White
                    ),
                    modifier = Modifier.weight(1f)
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Icon(
                        imageVector = if (isIconRotated) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                color = Color(0xFF7D451B).copy(alpha = 0.0f) // Set the alpha value here
            ) {
                Column {
                    Text(
                        text = breweries.city ?: "", style = TextStyle(
                            color = Color.White,
                            fontSize = cityTextSize,

                            )
                    )
                }
            }
            ShowAddInfo(showAdditionalInfo, breweries)
        }
    }


}

@Composable
fun ShowAddInfo(showAdditionalInfo: Boolean, breweries: Breweries){
    if (showAdditionalInfo) {
        Surface(
            modifier = Modifier
                .padding(vertical = 8.dp),
            color = Color(0xFF7D451B)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {

                Text(
                    text = "Type: ${breweries.type ?: "No type"}",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
                Text(
                    text = "State/Province: ${breweries.stateProvince ?: "No state/province"}",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
                Text(
                    text = "Country: ${breweries.country ?: "No country"}",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
            }
        }

        Surface(
            modifier = Modifier.padding(vertical = 8.dp),
            color = Color(0xFF7D451B)
        ) {
            Column {
                Text(
                    text = "Additional Information:", style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
                Text(
                    text = "Website URL: ${breweries.websiteUrl ?: "No website URL"}",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
                Text(
                    text = "Phone: ${breweries.phone ?: "No phone"}", style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun ShuffleButton(
    onClick: suspend () -> Unit,
    shape: androidx.compose.ui.graphics.Shape = FloatingActionButtonDefaults.extendedFabShape,
    containerColor: Color = Color(0xFFFBE29E), // This is the Material Design Orange 500 color
    contentColor: Color = contentColorFor(containerColor),
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    ExtendedFloatingActionButton(
        onClick = {
            coroutineScope.launch {
                onClick()
            }
        },
        modifier = Modifier
            .width(width = 200.dp)
            .padding(top = 40.dp, bottom = 30.dp),
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        elevation = elevation,
        interactionSource = interactionSource
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("New Brew")
            content()
        }
    }
}