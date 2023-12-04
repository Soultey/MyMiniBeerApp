

// PROJECT CODE *************************************************************

package com.example.lecture11code.data

import com.google.gson.Gson
import com.google.gson.JsonArray
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArtRepository(private val client: HttpClient)
{
    suspend fun getArtwork() : Art
    {
        val response = client.get(ApiEndpoints.BASE_URL.url)
        val json = response.body<JsonArray>().toString()
        return deserializeJson(json)
    }

    private fun deserializeJson(json: String): Art {
        val pieces = Gson().fromJson(json, Array<ArtPiece>::class.java).toList()
        return Art(pieces)
    }

}
