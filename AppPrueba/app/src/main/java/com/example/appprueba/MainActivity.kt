package com.example.appprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnSaludo: Button
    private lateinit var txtSaludo: TextView
    private lateinit var edtIntroduceNombre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSaludo = findViewById(R.id.btnSaludo)
        txtSaludo = findViewById(R.id.txtSaludo)
        edtIntroduceNombre = findViewById(R.id.edtIntroduceNombre)

        btnSaludo.setOnClickListener{
            txtSaludo.text = "Hola ${edtIntroduceNombre.text}"
        }
    }
}