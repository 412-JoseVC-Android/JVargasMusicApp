package com.example.jvargasmusicapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jvargasmusicapp.data.model.Album

@Composable
fun RecentAlbumItem(
    album: Album,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(20.dp),
        onClick = onClick
    ) {

        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(
                        Color(0xFFB39DDB),
                        RoundedCornerShape(16.dp)
                    )
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = album.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = album.artist,
                    color = Color.Gray
                )
            }
        }
    }
}