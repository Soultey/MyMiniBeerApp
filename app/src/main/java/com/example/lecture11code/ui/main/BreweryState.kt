package com.example.lecture11code.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.lecture11code.data.Breweries
import com.example.lecture11code.data.BreweryRepository

// Manages the state related to brewery data in the UI
class BreweryState(private val breweryRepository: BreweryRepository) {

    // MutableState holding the collection of Breweries (initially an empty list)
    var breweryCollection: MutableState<List<Breweries>> = mutableStateOf(emptyList())

    // Function to asynchronously fetch brewery data from the repository and update the state
    suspend fun getArtwork() {
        // Call the repository's getArtwork function to retrieve brewery data
        // Update the MutableState with the retrieved brewery collection
        breweryCollection.value = breweryRepository.getArtwork().breweries
    }
}
