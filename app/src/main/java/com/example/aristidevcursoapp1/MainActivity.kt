package com.example.aristidevcursoapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<AppCompatButton>(R.id.boton)
        val etName = findViewById<AppCompatEditText>(R.id.etName)

        boton.setOnClickListener(){
            var nombre: String = etName.text.toString()

            Log.i("Alert","${nombre.toString()}")

            if (nombre.isNotEmpty()){

                //Crea la variable donde se da contexto a kotlin, estamos en la actividad
                //actual (osease this) y luego queremos ir a ResulActivity (indicandole
                // que es una clase de java/kotlin)

                val intent = Intent(this, ResultActivity::class.java)

                // --------------------------*****--------------------------------

                //la instruccion putExtra sirve para adicionar datos de una pantalla a otra,
                //este dato en concreto tiene de nombre "Extra_Name" y le pasamos como parametro
                //la variable nombre

                intent.putExtra("Extra_Name",nombre)

                //----------------------------******--------------------------------------

                startActivity(intent)
            }

        }


    }
}