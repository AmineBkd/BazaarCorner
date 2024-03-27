package com.example.bazaarcorner.ui.screens.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.bazaarcorner.ui.navigation.routes.ScreenRoute
import com.example.bazaarcorner.ui.theme.white


@Composable
fun BottomNavigationBar(navController: NavController) {
    val selectedItemRoute by rememberSaveable { mutableStateOf(navController.currentDestination?.route) }

    val items = listOf(
        BottomNavigationItem("Home", ScreenRoute.HomeScreen.route, Icons.Filled.Home, Icons.Outlined.Home, false),
        BottomNavigationItem("Category", ScreenRoute.CategoryScreen.route, Icons.Filled.Email, Icons.Outlined.Email, false)
    )

    NavigationBar(containerColor = white) {
        items.forEach { item ->
            NavigationBarItem(
                label = { Text(item.title) },
                selected = selectedItemRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    when (selectedItemRoute) {
                        item.route -> Icon(item.selectedIcon, item.title)
                        else -> Icon(item.unselectedIcon, item.title)
                    }
                })
        }
    }
}

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
)
