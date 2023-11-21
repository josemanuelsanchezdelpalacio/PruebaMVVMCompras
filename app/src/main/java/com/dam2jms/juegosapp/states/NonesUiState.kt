package com.dam2jms.juegosapp.states

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class NonesUiState(
    val puntuacion: Int = 0,
    val seleccionJugador: String = "",
    val numeroJugador: Int = 0,
    var resultado: String = ""
)
