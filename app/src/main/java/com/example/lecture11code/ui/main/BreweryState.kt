

package com.example.lecture11code.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.lecture11code.data.Breweries
import com.example.lecture11code.data.BreweryRespository

class BreweryState(private val breweryRepository: BreweryRespository) {
    var breweryCollection: MutableState<List<Breweries>> = mutableStateOf(emptyList())

    suspend fun getArtwork() {
        breweryCollection.value = breweryRepository.getArtwork().breweries
    }
}

