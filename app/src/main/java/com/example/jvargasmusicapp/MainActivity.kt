package com.example.jvargasmusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jvargasmusicapp.navigation.AppNavigation
import com.example.jvargasmusicapp.ui.theme.JVargasMusicAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JVargasMusicAppTheme {
                AppNavigation()
            }
        }
    }
}