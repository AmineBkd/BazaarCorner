package com.example.bazaarcorner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bazaarcorner.ui.screens.home.HomeScreen
import com.example.bazaarcorner.ui.theme.BazaarCornerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BazaarCornerTheme(darkTheme = false) {
                //Home-001: Placeholer remove when navigation is implemented
                HomeScreen()
            }
        }
    }
}