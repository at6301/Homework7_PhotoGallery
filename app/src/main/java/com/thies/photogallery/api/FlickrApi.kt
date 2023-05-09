package com.thies.photogallery.api

import retrofit2.http.GET

private const val API_KEY = "6acbc8486ffcf810f03d38a1907d6854"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
            "&api_key=$API_KEY" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse
}