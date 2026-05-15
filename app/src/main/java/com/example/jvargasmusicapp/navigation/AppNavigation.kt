package com.example.jvargasmusicapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jvargasmusicapp.ui.screens.DetailScreen
import com.example.jvargasmusicapp.ui.screens.HomeScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("detail/{id}") {

            val id =
                it.arguments?.getString("id")?.toIntOrNull() ?: 0

            DetailScreen(
                navController = navController,
                albumId = id
            )
        }
    }
}