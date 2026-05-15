package com.example.jvargasmusicapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jvargasmusicapp.data.model.sampleAlbums
import com.example.jvargasmusicapp.ui.components.AlbumCard
import com.example.jvargasmusicapp.ui.components.MiniPlayer
import com.example.jvargasmusicapp.ui.components.RecentAlbumItem

@Composable
fun HomeScreen(
    navController: NavController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF6A1B9A),
                        Color(0xFF0F0F1A)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(20.dp)
            ) {

                item {

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "Good Evening",
                        color = Color.LightGray
                    )

                    Text(
                        text = "Jose Vargas",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Albums",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        items(sampleAlbums) { album ->

                            AlbumCard(
                                album = album,
                                onClick = {
                                    navController.navigate("detail/${album.id}")
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                }

                item {

                    Text(
                        text = "Recently Played",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }

                items(sampleAlbums) { album ->

                    RecentAlbumItem(
                        album = album,
                        onClick = {
                            navController.navigate("detail/${album.id}")
                        }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }

            MiniPlayer()
        }
    }
}