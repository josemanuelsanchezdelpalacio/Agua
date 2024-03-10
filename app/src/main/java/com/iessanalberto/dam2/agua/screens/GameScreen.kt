package com.iessanalberto.dam2.agua.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.iessanalberto.dam2.agua.data.allQuestions
import com.iessanalberto.dam2.agua.models.Question
import com.iessanalberto.dam2.agua.models.ViewModel
import com.iessanalberto.dam2.agua.navigation.AppScreens
import com.iessanalberto.dam2.agua.states.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navController: NavHostController, mvvm: ViewModel) {
    val uiState by mvvm.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "PUNTUACION: ${uiState.puntuacion}") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
    ) { paddingValues ->
        GameScreenBodyContent(modifier = Modifier.padding(paddingValues), mvvm, uiState)
    }
}

@Composable
fun GameScreenBodyContent(modifier: Modifier, mvvm: ViewModel, uiState: UiState) {
    var mostrarAlertDialog by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.numPregunta < 10) {
            Text(
                text = allQuestions[uiState.numPregunta].pregunta,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )

            val opciones = allQuestions[uiState.numPregunta].opciones

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            mvvm.onRespuestaSeleccionada(context, opciones[0])
                        }, colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .width(120.dp)
                            .height(200.dp)
                    ) {
                        Text(text = opciones[0])
                    }
                    Button(
                        onClick = {
                            mvvm.onRespuestaSeleccionada(context, opciones[1])
                        }, colors = ButtonDefaults.buttonColors(Color.Green),
                        modifier = Modifier
                            .width(120.dp)
                            .height(200.dp)
                    ) {
                        Text(text = opciones[1])
                    }
                }
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            mvvm.onRespuestaSeleccionada(context, opciones[2])
                        }, colors = ButtonDefaults.buttonColors(Color.Yellow),
                        modifier = Modifier
                            .width(120.dp)
                            .height(200.dp)
                    ) {
                        Text(text = opciones[2])
                    }
                    Button(
                        onClick = {
                            mvvm.onRespuestaSeleccionada(context, opciones[3])
                        }, colors = ButtonDefaults.buttonColors(Color.Blue),
                        modifier = Modifier
                            .width(120.dp)
                            .height(200.dp)
                    ) {
                        Text(text = opciones[3])
                    }
                }
            }
        } else {
            if (!mostrarAlertDialog) {
                mostrarAlertDialog = true
            }
            if (mostrarAlertDialog) {
                AlertDialog(
                    title = { Text(text = "FINAL DEL JUEGO") },
                    text = { Text(text = "Tu puntuacion final ha sido ${uiState.puntuacion}") },
                    onDismissRequest = {
                        mostrarAlertDialog = false
                    },
                    confirmButton = {
                        TextButton(onClick = {
                            mostrarAlertDialog = false
                            mvvm.reiniciarJuego()
                        }) {
                            Text(text = "Reiniciar juego")
                        }
                    }
                )
            }
        }
    }
}
