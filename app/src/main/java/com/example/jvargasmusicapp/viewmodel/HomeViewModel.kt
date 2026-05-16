package com.example.jvargasmusicapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jvargasmusicapp.data.model.Album
import com.example.jvargasmusicapp.data.repository.AlbumRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = AlbumRepository()

    var albums by mutableStateOf<List<Album>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf("")
        private set

    init {
        getAlbums()
    }

    private fun getAlbums() {

        viewModelScope.launch {

            try {

                Log.d("API_TEST", "Starting request")

                albums = repository.getAlbums()

                Log.d("API_TEST", "Albums loaded: ${albums.size}")

            } catch (e: Exception) {

                error = e.message ?: "Unknown error"

                Log.e("API_TEST", error)

            } finally {

                isLoading = false
            }
        }
    }
}