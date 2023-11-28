package com.dam2jms.juegosapp.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelSiete : ViewModel() {

    private val _puntuacionJugador = MutableLiveData(0.0)
    val puntuacionJugador: LiveData<Double> = _puntuacionJugador

    private val _puntuacionPC = MutableLiveData(0.0)
    val puntuacionPC: LiveData<Double> = _puntuacionPC

    private val _resultado = MutableLiveData("")
    val resultado: LiveData<String> = _resultado

    fun onJuego() {

        while (_puntuacionJugador.value!! >= 7.5){
            val cartasJugador = cartasAleatoria()
            _puntuacionJugador.value = valorCarta(cartasJugador)
            _resultado.value = "ganas"
        }

        while (_puntuacionPC.value!! >= 7.5){
            val cartasPC = cartasAleatoria()
            _puntuacionPC.value = valorCarta(cartasPC)
        }

        _resultado.value = "Resultado: ${_resultado.value}"
    }
}

fun cartasAleatoria(): String {
    return valorCartas.keys.toList().random()
}

fun valorCarta(carta: String): Double {
    return valorCartas[carta]!!
}

val valorCartas = mutableMapOf(
    "As" to 1.0,
    "2" to 2.0,
    "3" to 3.0,
    "4" to 4.0,
    "5" to 5.0,
    "6" to 6.0,
    "7" to 7.0,
    "Sota" to 0.5,
    "Caballo" to 0.5,
    "Rey" to 0.5
)