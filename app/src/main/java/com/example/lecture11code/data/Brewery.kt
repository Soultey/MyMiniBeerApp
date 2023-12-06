package com.example.lecture11code.data

import com.google.gson.annotations.SerializedName

// Data class defining the structure of Brewery containing a list of Breweries
data class Brewery(
    @SerializedName("data")
    val breweries: List<Breweries>
)

// Data class defining the structure of Breweries
data class Breweries(
    val id: String,
    val name: String?,
    @SerializedName("brewery_type")
    val type: String?,
    val city: String?,
    @SerializedName("state_province")
    val stateProvince: String?,
    @SerializedName("postal_code")
    val postalCode: String?,
    val country: String?,
    val longitude: String?,
    val latitude: String?,
    val phone: String?,
    @SerializedName("website_url")
    val websiteUrl: String?,
    val state: String?,
    val street: String?
)
