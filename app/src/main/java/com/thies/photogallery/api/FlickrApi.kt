package com.thies.photogallery.api

import retrofit2.http.GET

private const val API_KEY = "90a09b600afd1594f2d093de8719eaab"

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