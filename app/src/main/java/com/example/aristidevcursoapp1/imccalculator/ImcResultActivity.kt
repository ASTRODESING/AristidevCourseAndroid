package com.example.aristidevcursoapp1.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.aristidevcursoapp1.R
import com.example.aristidevcursoapp1.imccalculator.ImcActivity.Companion.IMC_KEY

class ImcResultActivity : AppCompatActivity() {

    private lateinit var primerResultado : TextView
    private lateinit var resultadoNumerico : TextView
    private lateinit var descripcionResultado : TextView
    private lateinit var btnRecalcular : AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)

        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0


        initComponents()
        initListeners()
        setResult(result)

    }

    private fun initComponents() {

        primerResultado = findViewById<TextView>(R.id.resumenResultado)
        resultadoNumerico = findViewById<TextView>(R.id.resultadoNumerico)
        descripcionResultado = findViewById<TextView>(R.id.resultadoDescripcion)
        btnRecalcular = findViewById<AppCompatButton>(R.id.recalcular)

    }


    private fun initListeners() {
        //Devolver a la pantalla anterior
        btnRecalcular.setOnClickListener{ onBackPressedDispatcher.onBackPressed()}
        //-------------------------------
    }


    private fun setResult(result:Double) {
        when(result){
            in 0.00 .. 18.5 -> resultDelgado(result)
            in 18.6 .. 25.0 -> resultNormal(result)
            in 25.1 .. 30.0 -> resultSobrepeso(result)
            in 30.1 .. 99.0 -> resultObesidad(result)
            else -> resultError(result)

        }
    }

    //Setear Resultados de acuerdo al IMC
    private fun resultDelgado(result: Double) {
        primerResultado.text = "Flaco"
        primerResultado.setTextColor(getColor(R.color.delgado))
        resultadoNumerico.text = result.toString()
        resultadoNumerico.setTextColor(getColor(R.color.delgado))
        descripcionResultado.text = "Por debajo de la media"
        descripcionResultado.setTextColor(getColor(R.color.delgado))

    }

    private fun resultNormal(result: Double) {
        primerResultado.text = "Normal"
        primerResultado.setTextColor(getColor(R.color.normal))
        resultadoNumerico.text = result.toString()
        resultadoNumerico.setTextColor(getColor(R.color.normal))
        descripcionResultado.text = "Posees una relacion altura/peso adecuada"
        descripcionResultado.setTextColor(getColor(R.color.normal))
    }

    private fun resultSobrepeso(result: Double) {
        primerResultado.text = "Obeso"
        primerResultado.setTextColor(getColor(R.color.gordo))
        resultadoNumerico.text = result.toString()
        resultadoNumerico.setTextColor(getColor(R.color.gordo))
        descripcionResultado.text = "Por encima de lo normal"
        descripcionResultado.setTextColor(getColor(R.color.gordo))
    }

    private fun resultObesidad(result: Double) {
        primerResultado.text = "Obesidad Morbida"
        primerResultado.setTextColor(getColor(R.color.sobrepeso))
        resultadoNumerico.text = result.toString()
        resultadoNumerico.setTextColor(getColor(R.color.sobrepeso))
        descripcionResultado.text = "Sobrepasas a la media de obesos"
        descripcionResultado.setTextColor(getColor(R.color.sobrepeso))
    }

    private fun resultError(result: Double) {
        primerResultado.text = "Error"
        primerResultado.setTextColor(getColor(R.color.error))
        resultadoNumerico.text = result.toString()
        resultadoNumerico.setTextColor(getColor(R.color.error))
        descripcionResultado.text = "capa 8"
        descripcionResultado.setTextColor(getColor(R.color.error))
    }

    //---------------------------------------------------


}