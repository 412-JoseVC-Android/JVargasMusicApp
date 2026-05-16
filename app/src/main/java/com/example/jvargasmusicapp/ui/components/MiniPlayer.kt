package com.example.jvargasmusicapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jvargasmusicapp.data.model.Album

@Composable
fun MiniPlayer(album: Album?) {
    if (album == null) return

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp) // Despegado del borde
            .fillMaxWidth()
            .background(
                Color(0xFF1A1A1A),
                RoundedCornerShape(20.dp)
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = album.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = album.title,
                color = Color.White,
                fontSize = 14.sp,
                maxLines = 1
            )
            Text(
                text = album.artist,
                color = Color.LightGray,
                fontSize = 12.sp,
                maxLines = 1
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .background(Color.White, CircleShape)
                .size(36.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}