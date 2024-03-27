package com.example.bazaarcorner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.bazaarcorner.ui.navigation.AppNavHost
import com.example.bazaarcorner.ui.theme.BazaarCornerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BazaarCornerTheme(darkTheme = false) {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}