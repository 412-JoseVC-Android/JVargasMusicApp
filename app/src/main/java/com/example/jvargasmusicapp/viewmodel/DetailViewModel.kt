package com.example.jvargasmusicapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jvargasmusicapp.data.model.Album
import com.example.jvargasmusicapp.data.repository.AlbumRepository
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val repository = AlbumRepository()

    var album by mutableStateOf<Album?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    fun getAlbum(id: String) {
        viewModelScope.launch {
            isLoading = true
            try {
                album = repository.getAlbumById(id)
            } catch (e: Exception) {
                error = e.message ?: "Error loading album"
            } finally {
                isLoading = false
            }
        }
    }
}