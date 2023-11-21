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

    fun onJuego(context: Context) {
        // genero de forma aleatoria que el PC escoja entre pares o nones
        val seleccionPC: String = if (_seleccionJugador.value == "nones") "pares" else "nones"

        // genero un numero aleatorio entre 1 y 5 para la PC
        _numeroPC.value = (1..5).random()
        val suma = _numeroJugador.value!! + _numeroPC.value!!

        //compruebo que la seleccion del jugador solo pueda ser pares o nones
        when (_seleccionJugador.value?.toLowerCase()) {
            "pares", "nones" -> {

                // si el numero del jugador es mayor o igual a 1 y es menor o igual a 5.
                // si no, saca mensaje de que el numero tiene que ser entre 1 y 5
                if (_numeroJugador.value in 1..5) {
                    // si es nones y es impar la suma o si es pares y es par la suma
                    if ((_seleccionJugador.value == "nones" && suma % 2 != 0) || (_seleccionJugador.value == "pares" && suma % 2 == 0)) {
                        _resultado.value = "ganas"
                        _puntuacion.value = (_puntuacion.value ?: 0) + 1
                    } else {
                        _resultado.value = "pierdes"
                        val nuevaPuntuacion = (_puntuacion.value ?: 0) - 1
                        //para que no pueda bajar la puntuacion de 0
                        _puntuacion.value = if (nuevaPuntuacion < 0) 0 else nuevaPuntuacion
                    }

                    //muestro el resultado
                    _resultado.value =
                        "Jugador: ${_seleccionJugador.value} ${_numeroJugador.value}\n PC: $seleccionPC. ${_numeroPC.value}\n Resultado: ${_resultado.value}"

                } else {
                    Toast.makeText(context, "El numero debe ser entre 1 y 5", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            else -> {
                Toast.makeText(
                    context,
                    "Solo puedes elejir entre pares o nones",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}