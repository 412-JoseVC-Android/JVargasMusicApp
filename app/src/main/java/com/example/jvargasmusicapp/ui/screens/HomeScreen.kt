package com.example.jvargasmusicapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jvargasmusicapp.viewmodel.HomeViewModel
import com.example.jvargasmusicapp.ui.components.AlbumCard
import com.example.jvargasmusicapp.ui.components.MiniPlayer
import com.example.jvargasmusicapp.ui.components.RecentAlbumItem

@Composable
fun HomeScreen(
    onAlbumClick: (String) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val albums = viewModel.albums

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF5B1E8B),
                        Color(0xFF0D0D16),
                        Color(0xFF090909)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = 60.dp,
                    bottom = 120.dp
                )
            ) {
                item {
                    Text(
                        text = "Good Evening",
                        color = Color.LightGray,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Jose Vargas",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(36.dp))

                    if (viewModel.isLoading) {
                        Box(
                            modifier = Modifier.fillMaxWidth().height(200.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(color = Color.White)
                        }
                    } else if (viewModel.error.isNotEmpty()) {
                        Text(
                            text = viewModel.error,
                            color = Color.Red,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    } else {
                        Text(
                            text = "Albums",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(18.dp)
                        ) {
                            items(albums) { album ->
                                AlbumCard(
                                    album = album,
                                    onClick = { onAlbumClick(album.id) }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(36.dp))

                        Text(
                            text = "Recently Played",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(14.dp))
                    }
                }

                if (!viewModel.isLoading && viewModel.error.isEmpty()) {
                    items(albums) { album ->
                        RecentAlbumItem(
                            album = album,
                            onClick = { onAlbumClick(album.id) }
                        )
                    }
                }
            }

            MiniPlayer()
        }
    }
}