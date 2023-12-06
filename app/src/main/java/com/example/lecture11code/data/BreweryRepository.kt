package com.example.lecture11code.data

import com.google.gson.Gson
import com.google.gson.JsonArray
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

// Repository handling brewery-related data fetching and deserialization
class BreweryRepository(private val client: HttpClient) {

    // Function to fetch brewery data asynchronously
    suspend fun getArtwork(): Brewery {
        // Make a GET request to the defined base URL from ApiEndpoints
        val response = client.get(ApiEndpoints.BASE_URL.url)

        // Read the response body as a JSON array and convert it to a string
        val json = response.body<JsonArray>().toString()

        // Deserialize the JSON string to a Brewery object
        return deserializeJson(json)
    }

    // Function to deserialize JSON string to a Brewery object
    private fun deserializeJson(json: String): Brewery {
        // Use Gson to deserialize the JSON array to an array of Breweries, then convert it to a list
        val pieces = Gson().fromJson(json, Array<Breweries>::class.java).toList()

        // Create a Brewery object from the list of Breweries
        return Brewery(pieces)
    }
}
