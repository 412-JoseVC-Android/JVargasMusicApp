package com.example.jvargasmusicapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jvargasmusicapp.data.model.Album

@Composable
fun AlbumCard(
    album: Album,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .width(220.dp)
            .height(280.dp),
        shape = RoundedCornerShape(24.dp),
        onClick = onClick
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF9C27B0),
                            Color(0xFF311B92)
                        )
                    )
                )
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {

                Text(
                    text = album.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )

                Text(
                    text = album.artist,
                    color = Color.LightGray
                )
            }

            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .background(Color.White, CircleShape)
            ) {

                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}