package com.dam2jms.pruebamvvm

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.system.exitProcess

class MainViewModel : ViewModel() {

    private val _usuario = MutableLiveData<String>()
    val usuario: LiveData<String> = _usuario

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onUserPasswordChanged(usuario: String, password: String) {
        _usuario.value = usuario
        _password.value = password
    }

    fun validar(usuario: String, password: String, context: Context) {

        var numIntentos = 3

        //si ambas son correctas saca mensaje de acierto
        if (usuario == "admin" && password == "admin") {
            //si acierta reinicia el numero de intentos
            numIntentos = 3
        }else {
            //si al introducir de forma incorrecta 3 veces la contraseña entonces saca un mensaje y cierra la app
            numIntentos--
            if (numIntentos.equals(0)) {
                //variable para controlar el cierre de la app cuando supere el numero de intentos
                Toast.makeText(context, "El numero de intentos ha sido superado", Toast.LENGTH_SHORT).show()
                exitProcess(0)
            }
        }

        if (usuario.equals("") && password.equals("")) {
            Toast.makeText(context, "Ambos campos estan vacios", Toast.LENGTH_SHORT).show()
        }
    }
}
