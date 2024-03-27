package com.example.bazaarcorner.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bazaarcorner.ui.component.home.SearchTextFieldComponent
import com.example.bazaarcorner.ui.screens.navigation.BottomNavigationBar
import com.example.bazaarcorner.ui.screens.HomeScreenTopAppBar
import com.example.bazaarcorner.ui.theme.backgroundHome
import com.example.bazaarcorner.ui.theme.white

@Composable
fun HomeScreen(navController: NavController) {
    Surface(Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { HomeScreenTopAppBar() },
            bottomBar = { BottomNavigationBar(navController = navController) },
        ) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                HomeScreenContent()
            }
        }
    }
}

@Composable
fun HomeScreenContent() {
    val bottomRoundedCornerShapeValue = 12.dp

    Column(
        Modifier
            .background(backgroundHome)
            .fillMaxSize()
    ) {

        Column(
            Modifier
                .shadow(4.dp)
                .fillMaxWidth()
                .background(
                    white,
                    shape = RoundedCornerShape(
                        bottomEnd = bottomRoundedCornerShapeValue,
                        bottomStart = bottomRoundedCornerShapeValue
                    )
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                SearchTextFieldComponent(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                )
            }
        }
    }
}