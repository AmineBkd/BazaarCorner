package com.example.bazaarcorner.ui.screens.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bazaarcorner.ui.screens.navigation.BottomNavigationBar
import com.example.bazaarcorner.ui.screens.HomeScreenTopAppBar


@Composable
fun CategoryScreen(navController: NavController) {
    Surface {
        Scaffold(
            topBar = { HomeScreenTopAppBar() },
            bottomBar = { BottomNavigationBar(navController = navController) }) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                Text("CategoryScreen")
                Button(onClick = { /*TODO*/ }) {
                }
            }
        }
    }
}