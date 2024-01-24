package com.example.aristidevcursoapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val tvResult = findViewById<TextView>(R.id.textViewResult)
        val contra = findViewById<TextView>(R.id.contra)

        //Se obtiene la variable enviada atravez del intent

        val name: String = intent.extras?.getString("Extra_Name").orEmpty()

        //----------------------------------------**********-------------------------------

        tvResult.text = "Hola ${name.toString()}"

        if(name.toString() == "ermanolitox"){
            contra.visibility = View.VISIBLE
        }
    }
}