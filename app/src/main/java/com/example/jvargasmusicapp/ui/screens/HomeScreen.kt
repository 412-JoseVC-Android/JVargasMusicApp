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
                        color = Color.LightGray
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Jose Vargas",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(36.dp))

                    Text(
                        text = "Albums",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(18.dp))
                }

                item {

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(18.dp)
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

                    Spacer(modifier = Modifier.height(36.dp))
                }

                item {

                    Text(
                        text = "Recently Played",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(14.dp))
                }

                items(sampleAlbums) { album ->

                    RecentAlbumItem(
                        album = album,
                        onClick = {
                            navController.navigate("detail/${album.id}")
                        }
                    )
                }
            }

            MiniPlayer()
        }
    }
}