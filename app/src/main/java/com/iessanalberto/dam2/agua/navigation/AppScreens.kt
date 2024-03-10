package com.iessanalberto.dam2.agua.navigation

sealed class AppScreens (val route: String){
    object FirstScreen: AppScreens(route = "first_screen")
    object GameScreen: AppScreens(route = "game_screen")
}