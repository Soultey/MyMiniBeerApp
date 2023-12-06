
package com.example.lecture11code.data

import com.google.gson.Gson
import com.google.gson.JsonArray
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class BreweryRespository(private val client: HttpClient)
{
    suspend fun getArtwork() : Brewery
    {
        val response = client.get(ApiEndpoints.BASE_URL.url)
        val json = response.body<JsonArray>().toString()
        return deserializeJson(json)
    }

    private fun deserializeJson(json: String): Brewery {
        val pieces = Gson().fromJson(json, Array<Breweries>::class.java).toList()
        return Brewery(pieces)
    }

}
