package com.dam2jms.juegosapp.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModelSiete {

    private val _puntuacionJugador = MutableLiveData<Double>(0.0)
    val puntuacionJugador: LiveData<Double> = _puntuacionJugador

    private val _puntuacionPC = MutableLiveData<Double>(0.0)
    val puntuacionPC: LiveData<Double> = _puntuacionPC

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> = _resultado

    fun onJuego() {
        //cada jugador toma 7 cartas de forma aleatoria
        val cartasPC: String = cartasAleatoria()
        val cartasJugador: String = cartasAleatoria()

        //segun las cartas de cada uno sumo los valores
        _puntuacionJugador.value = _puntuacionJugador.value?.plus(valorCarta(cartasJugador))
        _puntuacionPC.value = _puntuacionPC.value?.plus(valorCarta(cartasPC))

        //si esas cartas llegan a 7.5 saca el resultado segun quien haya llegado a ese numero
        if(_puntuacionJugador.value!! >= 7.5){
            _resultado.value = "ganas"
        }else if(_puntuacionPC.value!! >= 7.5){
            _resultado.value = "pierdes"
        }

        _resultado.value = "Resultado: ${_resultado.value}"
    }
}

//metodo para obtener 7 cartas de forma aleatoria
fun cartasAleatoria(): String {
    val cartas = listOf("As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey")
    return cartas.shuffled().take(7).toString()
}

//valor cartas
fun valorCarta(carta: String): Double {
    return when (carta) {
        "As" -> 1.0
        "2" -> 2.0
        "3" -> 3.0
        "4" -> 4.0
        "5" -> 5.0
        "6" -> 6.0
        "7" -> 7.0
        "Sota", "Caballo", "Rey" -> 0.5
        else -> carta.toDouble()
    }
}