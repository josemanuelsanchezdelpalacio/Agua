package com.iessanalberto.dam2.agua.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.agua.navigation.AppScreens

@Composable
fun FirstScreen(navController: NavController) {
    Scaffold {
        paddingValues -> FirstScreenBodyContent(navController = navController,modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun FirstScreenBodyContent(navController: NavController, modifier: Modifier) {
    Column (modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)) {
        Text(text = "¿Cuánto sabes sobre lo que gastas de agua?. \n Responde a las preguntas en el menor tiempo posible. \nBuena suerte")
        OutlinedButton(onClick = { navController.navigate(AppScreens.GameScreen.route) }) {
            Text(text = "Empezar juego")
        }
    }
}
