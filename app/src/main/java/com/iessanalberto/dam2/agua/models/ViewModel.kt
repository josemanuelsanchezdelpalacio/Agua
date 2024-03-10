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
