
// PROJECT CODE *************************************************************

package com.example.lecture11code.data

enum class ApiEndpoints(val url:String)
{
    BASE_URL("https://api.openbrewerydb.org/v1/breweries/random"),
    ARTWORK("${BASE_URL.url}/artworks"),
    FIELDS("${ARTWORK.url}?fields=id,title,image_id")
}
