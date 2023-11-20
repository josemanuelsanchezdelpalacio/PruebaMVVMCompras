package com.dam2jms.juegosapp.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ViewModelNones:ViewModel() {

    private val _puntuacion = MutableLiveData<Int>()
    val puntuacion: LiveData<Int> = _puntuacion

    private val _isParesJugador = MutableLiveData<Boolean>()
    val isParesJugador: LiveData<Boolean> = _isParesJugador

    private val _seleccionJugador = MutableLiveData<String>()
    val seleccionJugador: LiveData<String> = _seleccionJugador

    private val _numeroJugador = MutableLiveData<Int>()
    val numeroJugador: LiveData<Int> = _numeroJugador

    private val _numeroPC = MutableLiveData<Int>()
    val numeroPC: LiveData<Int> = _numeroPC

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> = _resultado


    fun onSeleccionJugador(seleccionJugadorUi: String, numeroJugadorUi: Int) {
        _seleccionJugador.value = seleccionJugadorUi
        _numeroJugador.value = numeroJugadorUi
    }

    fun onJuego(seleccionJugador: String, numeroJugador: Int, context: Context) {
        // genero de forma aleatoria que el PC escoja entre pares o nones
        val seleccionPC: String = if(seleccionJugador == "nones"){
            "pares"
        }else{
            "nones"
        }
        // genero un numero aleatorio entre 1 y 5 para la PC
        val numeroPC = (1..5).random()
        val suma = numeroJugador + numeroPC

        // si el numero del jugador es mayor o igual a 1 y es menor o igual a 5.
        // si no, saca mensaje de que el numero tiene que ser entre 1 y 5
        if (numeroJugador in 1..5) {
            // si es nones y es impar la suma o si es pares y es par la suma
            if ((seleccionJugador == "nones" && suma % 2 != 0) || (seleccionJugador == "pares" && suma % 2 == 0)) {
                _resultado.value = "ganas"
                _puntuacion.value =- 10
            } else {
                _resultado.value = "pierdes"
                _puntuacion.value =- 5
            }
        } else {
            Toast.makeText(context, "El numero debe ser entre 1 y 5", Toast.LENGTH_SHORT).show()
        }

        _resultado.value = "Usuario: $seleccionJugador. $numeroJugador\n PC: $seleccionPC. $numeroPC\n Resultado: ${_resultado.value}"

    }
}