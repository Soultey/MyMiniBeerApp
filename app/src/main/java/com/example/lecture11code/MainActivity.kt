
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

        val artRepository = (application as MyApp).breweryRepository

        setContent {
            val artState = BreweryState(artRepository)

            LaunchedEffect(key1 = artState, block = {

                artState.getArtwork()

            })

            MainContent(breweryState = artState)
        }
    }
}


