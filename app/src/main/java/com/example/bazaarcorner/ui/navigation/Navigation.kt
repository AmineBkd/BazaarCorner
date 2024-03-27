package com.example.bazaarcorner.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bazaarcorner.ui.navigation.routes.ScreenRoute
import com.example.bazaarcorner.ui.screens.categories.CategoryScreen
import com.example.bazaarcorner.ui.screens.home.HomeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = ScreenRoute.HomeScreen.route) {
        composable(ScreenRoute.HomeScreen.route) { HomeScreen(navController) }
        composable(ScreenRoute.CategoryScreen.route) { CategoryScreen(navController) }
    }
}