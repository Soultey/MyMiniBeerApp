// PROJECT CODE *************************************************************

package com.example.lecture11code

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lecture11code.data.ArtPiece
import com.example.lecture11code.ui.main.ArtState
import kotlinx.coroutines.launch
import androidx.compose.material3.Card


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val artRepository = (application as MyApp).artRepository

        setContent {
            val artState = ArtState(artRepository)

            LaunchedEffect(key1 = artState, block = {

                artState.getArtwork()

            })

            MainContent(artState = artState)
        }
    }
}

@Composable
fun MainContent(artState: ArtState) {

    val currentArtIndex = remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        artState.getArtwork()
    }

    LazyColumn(content = {
        items(artState.artwork.value.size) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()

            ) {
                ShuffleButton(
                    onClick = {
                        artState.getArtwork()
                    },
                ) {}

                DisplayArtPiece(artState.artwork.value[currentArtIndex.intValue])

            }

        }
    })
}

@Composable
fun DisplayArtPiece(artPiece: ArtPiece) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp) // Adjust padding as needed

    ){
        Column (
            modifier = Modifier.padding(20.dp)
        ){
            Text(text = artPiece.name ?: "No name")
            Text(text = artPiece.type ?: "No type")
            Text(text = artPiece.address1 ?: "No address1")
            Text(text = artPiece.address2 ?: "No address2")
            Text(text = artPiece.address3 ?: "No address3")
            Text(text = artPiece.city ?: "No city")
            Text(text = artPiece.stateProvince ?: "No state/province")
            Text(text = artPiece.postalCode ?: "No postal code")
            Text(text = artPiece.country ?: "No country")
            Text(text = artPiece.longitude ?: "No longitude")
            Text(text = artPiece.latitude ?: "No latitude")
            Text(text = artPiece.phone ?: "No phone")
            Text(text = artPiece.websiteUrl ?: "No website URL")
            Text(text = artPiece.state ?: "No state")
            Text(text = artPiece.street ?: "No street")
        }
    }

}

@Composable
fun ShuffleButton(
    onClick: suspend () -> Unit,
    shape: androidx.compose.ui.graphics.Shape = FloatingActionButtonDefaults.extendedFabShape,
    containerColor: Color = FloatingActionButtonDefaults.containerColor,
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
            .padding(top = 10.dp),
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

