package com.example.bazaarcorner.ui.navigation.routes

sealed class ScreenRoute(val route: String) {
    object HomeScreen: ScreenRoute("home")
    object CategoryScreen: ScreenRoute("category")
}