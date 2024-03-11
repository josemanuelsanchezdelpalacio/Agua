package com.iessanalberto.dam2.agua.models

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.iessanalberto.dam2.agua.data.allQuestions
import com.iessanalberto.dam2.agua.states.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun siguientePregunta() {
        _uiState.value = _uiState.value.copy(numPregunta = _uiState.value.numPregunta + 1)
    }

    fun onRespuestaSeleccionada(context: Context, respuestaSeleccionada: String) {
        if (respuestaSeleccionada == allQuestions[_uiState.value.numPregunta].respuestaCorrecta) {
            Toast.makeText(context, "CORRECTO. Has acertado", Toast.LENGTH_SHORT).show()
            _uiState.value.puntuacion += 5
        } else {
            Toast.makeText(
                context,
                "ERROR. La respuesta correcta es: ${allQuestions[_uiState.value.numPregunta].respuestaCorrecta}",
                Toast.LENGTH_SHORT
            ).show()
            if (_uiState.value.puntuacion > 0) {
                _uiState.value.puntuacion -= 5
            }
        }
        siguientePregunta()
    }

    fun reiniciarJuego() {
        _uiState.value.numPregunta = 0
        _uiState.value.puntuacion = 0
    }
}


/*
* class ViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        generarNumeroSecreto()
    }

    private fun generarNumeroSecreto() {
        val numeros = ('0'..'9').shuffled().take(5).joinToString("")
        _uiState.value = _uiState.value.copy(numeroSecreto = numeros)
    }

    fun comprobarRespuesta(respuesta: String) {
        val numeroSecreto = _uiState.value.numeroSecreto
        var puntuacion = _uiState.value.puntuacion
        var intentos = _uiState.value.intentos

        if (respuesta == numeroSecreto) {
            // El jugador ha adivinado el número
            puntuacion += when (intentos) {
                in 0..2 -> 20
                in 3..6 -> 15
                else -> 10
            }
            _uiState.value = _uiState.value.copy(puntuacion = puntuacion, finDelJuego = true)
        } else {
            // El jugador no ha adivinado el número
            intentos++
            _uiState.value = _uiState.value.copy(intentos = intentos)
            if (intentos >= 10) {
                // El jugador ha agotado todos sus intentos
                _uiState.value = _uiState.value.copy(finDelJuego = true)
            }
        }
    }

    fun reiniciarJuego() {
        _uiState.value = UiState()
        generarNumeroSecreto()
    }
}
*
*
*
* @Composable
fun GameScreen(mvvm: ViewModel) {
    val uiState by mvvm.uiState.collectAsState()

    if (uiState.finDelJuego) {
        // Mostrar el fin del juego y la puntuación final
        Text(text = "Fin del juego. Tu puntuación final es ${uiState.puntuacion}.")
        Button(onClick = { mvvm.reiniciarJuego() }) {
            Text(text = "Volver a jugar")
        }
    } else {
        // Mostrar el juego
        Text(text = "Intento ${uiState.intentos} de 10")
        Text(text = "Puntuación: ${uiState.puntuacion}")
        TextField(
            value = "",
            onValueChange = { mvvm.comprobarRespuesta(it) },
            label = { Text("Introduce un número") }
        )
    }
}

*
*
*
* */