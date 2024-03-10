package com.iessanalberto.dam2.agua.models

import kotlin.random.Random

/*
* La clase Question almacena cada una de las preguntas del juego,
* incluyendo la lista de respuestas posibles que se genera a través del constructor
 */
class Question(
    var pregunta: String,
    var tipo: String,// Pueden ser una de estas opciones List<String> = listOf("number","yesNo","trueOrfalse"),
    var respuestaCorrecta: String,
    var opciones: MutableList<String>
) {
    constructor(pregunta: String, tipo: String, respuestaCorrecta: String) :
            this(
                pregunta = pregunta,
                tipo = tipo,
                respuestaCorrecta = respuestaCorrecta,
                opciones = mutableListOf()
            ) {
        this.pregunta = pregunta
        this.tipo = tipo
        this.respuestaCorrecta = respuestaCorrecta
        if (tipo.equals("number")) {
            this.opciones.add(respuestaCorrecta)
            this.opciones.add(calcularAleatorio(respuestaCorrecta.toInt()).toString())
            this.opciones.add(calcularAleatorio(respuestaCorrecta.toInt()).toString())
            this.opciones.add(calcularAleatorio(respuestaCorrecta.toInt()).toString())
        } else if (tipo.equals("yesNo")) {
            this.opciones.add("Sí")
            this.opciones.add("Depende")
            this.opciones.add("No")
            this.opciones.add("¿Tú que crees?")
        } else if (tipo.equals("verdaderoFalso")) {
            this.opciones.add("Verdadero")
            this.opciones.add("Falso")
            this.opciones.add("Depende")
            this.opciones.add("Pasapalabra")
        }
        this.opciones.shuffled()

    }

    fun calcularAleatorio(numero: Int): Int {
        return Random.nextInt((numero * 0.5).toInt(), (numero * 1.5).toInt())
    }

}

