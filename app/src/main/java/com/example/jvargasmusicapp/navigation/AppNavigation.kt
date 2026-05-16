package com.example.jvargasmusicapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.jvargasmusicapp.ui.screens.DetailScreen
import com.example.jvargasmusicapp.ui.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Detail(val id: String)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen(
                onAlbumClick = { id ->
                    navController.navigate(Detail(id))
                }
            )
        }

        composable<Detail> { backStackEntry ->
            val detail: Detail = backStackEntry.toRoute()
            DetailScreen(
                navController = navController,
                albumId = detail.id
            )
        }
    }
}