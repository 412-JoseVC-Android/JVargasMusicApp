package com.example.jvargasmusicapp.data.repository

import com.example.jvargasmusicapp.data.remote.RetrofitInstance

class AlbumRepository {

    suspend fun getAlbums() =
        RetrofitInstance.api.getAlbums()

    suspend fun getAlbumById(id: String) =
        RetrofitInstance.api.getAlbumById(id)
}