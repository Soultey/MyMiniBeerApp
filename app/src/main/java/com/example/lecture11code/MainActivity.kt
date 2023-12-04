
// PROJECT CODE *************************************************************


package com.example.lecture11code

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.lecture11code.ui.main.ArtState

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
    LazyColumn(content = {
        items(artState.artwork.value.size) { index ->
            val artPiece = artState.artwork.value[index]
            Column {
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
    })
}



