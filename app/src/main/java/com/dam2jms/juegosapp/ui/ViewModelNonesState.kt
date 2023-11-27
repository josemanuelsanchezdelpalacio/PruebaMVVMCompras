package com.dam2jms.juegosapp.ui

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NonesViewModel : ViewModel() {
    // Propiedades del estado del juego
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState

    // Método para manejar cambios en la selección y el número del jugador
    fun onChange(seleccion: String, numero: Int) {
        _uiState.value = _uiState.value.copy(seleccionJugador = seleccion, numeroJugador = numero)
    }
    
    // Método para iniciar el juego
    fun onJuego(context: Context) {
        val seleccionPC: String = if (_uiState.value.seleccionJugador == "nones") "pares" else "nones"
        val numeroPC = (1..5).random()
        val suma = _uiState.value.numeroJugador + numeroPC

        if (_uiState.value.seleccionJugador == "pares" || _uiState.value.seleccionJugador == "nones") {
            if (_uiState.value.numeroJugador in 1..5) {
                val resultadoJuego = if ((_uiState.value.seleccionJugador == "nones" && suma % 2 != 0) || (_uiState.value.seleccionJugador == "pares" && suma % 2 == 0)) {
                    _uiState.value = _uiState.value.copy(
                        puntuacion = _uiState.value.puntuacion + 10,
                        resultado = "ganas"
                    )
                    "ganas"
                } else {
                    _uiState.value = _uiState.value.copy(
                        puntuacion = _uiState.value.puntuacion - 5,
                        resultado = "pierdes"
                    )
                    "pierdes"
                }

                _uiState.value = _uiState.value.copy(
                    resultado = "Jugador: ${_uiState.value.seleccionJugador} ${_uiState.value.numeroJugador}\nPC: $seleccionPC. $numeroPC\nResultado: $resultadoJuego"
                )
            } else {
                Toast.makeText(context, "El número debe estar entre 1 y 5", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Solo puedes elegir entre pares o nones", Toast.LENGTH_SHORT).show()
        }
    }
}
