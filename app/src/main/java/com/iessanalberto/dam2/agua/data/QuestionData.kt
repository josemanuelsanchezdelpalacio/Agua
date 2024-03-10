package com.iessanalberto.dam2.agua.data

import com.iessanalberto.dam2.agua.models.Question

// Tipos: number, yesNo, verdaderoFalso
val question1 = Question(pregunta = "¿Cuántos litros de agua potable consumes en una ducha", tipo = "number", respuestaCorrecta = "40")
val question2 = Question(pregunta = "¿Cuántos litros por día consumes?", tipo = "number", respuestaCorrecta = "136")
val question3 = Question(pregunta = "¿Cuánta agua usa el inodoro en una descarga?", tipo = "number", respuestaCorrecta = "5")
val question4 = Question(pregunta = "¿Cuánta agua gasta el lavavajillas en un ciclo?", tipo = "number", respuestaCorrecta = "14")
val question5 = Question(pregunta = "¿Cuánta agua gasta la lavadora en un ciclo normal?", tipo = "number", respuestaCorrecta = "45")
val question6 = Question(pregunta = "Gasta más agua lavar a mano que poner un lavavajillas", tipo = "verdaderoFalso", respuestaCorrecta = "Verdadero")
val question7 = Question(pregunta = "¿Cuántos litros de agua hacen falta para fabricar un pantalón vaquero?", tipo = "number", respuestaCorrecta = "7500")
val question8 = Question(pregunta = "¿Cuántos litros de agua hacen falta para producir un kilo de carne?", tipo = "number", respuestaCorrecta = "10000")
val question9 = Question(pregunta = "¿Cuántos litros de agua hacen falta para producir un kilo de verdura?", tipo = "number", respuestaCorrecta = "300")
val question10 = Question(pregunta = "¿Cuántos litros de agua hacen falta para llenar una piscina olímpica?", tipo = "number", respuestaCorrecta = "3000000")
val question11 = Question(pregunta = "¿Cuántas piscinas hay en España?", tipo = "numbers", respuestaCorrecta = "1300000")
val question12 = Question(pregunta = "¿Cuántos litros de agua hacen falta para fabricar una camiseta de algodón?", tipo = "number", respuestaCorrecta = "2700")
val question13 = Question(pregunta = "El agua del grifo es mejor que la embotellada", tipo = "verdaderoFalso", respuestaCorrecta = "Verdadero")
val question14 = Question(pregunta = "¿Es potable el agua de la fuente de Santa Elena?", tipo = "yesNo", respuestaCorrecta = "No")
val question15 = Question(pregunta = "¿Es potable el agua de lluvia?", tipo = "yesNo", respuestaCorrecta = "No")
val question16 = Question(pregunta = "¿Es potable el agua de los ríos de montaña?", tipo = "yesNo", respuestaCorrecta = "Depende")
val question17 = Question(pregunta = "¿Cuántas toneladas de plásticos se vierten al mar Mediterráneo cada año?", tipo = "number", respuestaCorrecta = "200000")
val question18 = Question(pregunta = "Para producir un litro de leche hacen falta 1000 de agua", tipo = "yesNo", respuestaCorrecta = "Sí")
val question19 = Question(pregunta = "Para producir una hamburguesa con patatas fritas hacen falta más de 10.000 litros", tipo = "verdaderoFalso", respuestaCorrecta = "Falso")
val question20 = Question(pregunta = "Para descargar un gigabyte de Internet se consumen 200 litros", tipo = "verdaderoFalso", respuestaCorrecta = "Verdadero")


val allQuestions : List<Question> = listOf(
    question1,
    question2,
    question3,
    question4,
    question5,
    question6,
    question7,
    question8,
    question9,
    question10,
    question11,
    question12,
    question13,
    question14,
    question15,
    question16,
    question17,
    question18,
    question19,
    question20
)