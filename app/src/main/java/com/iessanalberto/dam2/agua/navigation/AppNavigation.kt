package com.iessanalberto.dam2.agua.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iessanalberto.dam2.agua.models.ViewModel
import com.iessanalberto.dam2.agua.screens.FirstScreen
import com.iessanalberto.dam2.agua.screens.GameScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route) { FirstScreen(navController)}
        composable(route = AppScreens.GameScreen.route) { GameScreen(navController, mvvm = ViewModel() ) }
    }
}