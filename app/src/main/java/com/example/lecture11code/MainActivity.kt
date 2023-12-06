package com.example.lecture11code

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import com.example.lecture11code.ui.main.BreweryState
import com.example.lecture11code.ui.main.MainContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve the BreweryRepository from the application context
        val artRepository = (application as MyApp).breweryRepository

        // Set the Composable content of the activity
        setContent {
            // Create an instance of BreweryState by passing the artRepository
            val artState = BreweryState(artRepository)

            // Execute the getArtwork method when the composition is launched
            LaunchedEffect(key1 = artState, block = {
                artState.getArtwork()
            })

            // Display the main content of the app using MainContent Composable
            MainContent(breweryState = artState)
        }
    }
}
