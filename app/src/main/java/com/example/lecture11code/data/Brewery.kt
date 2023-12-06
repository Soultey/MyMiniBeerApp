
package com.example.lecture11code.data

import com.google.gson.annotations.SerializedName

data class Brewery(
    @SerializedName("data")
    val breweries: List<Breweries>
)

data class Breweries(

    val id: String,
    val name: String?,
    @SerializedName("brewery_type")
    val type: String?,
    val address1: String?,
    val address2: String?,
    val address3: String?,
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
