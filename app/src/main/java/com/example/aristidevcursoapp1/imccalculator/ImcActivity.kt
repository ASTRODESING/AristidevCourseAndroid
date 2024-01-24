package com.example.aristidevcursoapp1.imccalculator


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.aristidevcursoapp1.R
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {
    //se inicializan las variables de seleccion

    private var isMaleSelected=true
    private var isFemaleSelected=false
    private var currentPeso = 40
    private var currentEdad = 18
    private var currentAltura = 120
    private var currentImc: Double = 0.0
    //-------------------------------------
    //se declaran las variables contenedroas de los componentes para iniciarlas mas tarde

    private lateinit var btnHombre : CardView
    private lateinit var btnMujer : CardView
    private lateinit var valorAltura : TextView
    private lateinit var rsAltura : RangeSlider
    private lateinit var valorEdad : TextView
    private lateinit var valorPeso : TextView
    private lateinit var btnMasEdad : FloatingActionButton
    private lateinit var btnMenosEdad : FloatingActionButton
    private lateinit var btnMasPeso : FloatingActionButton
    private lateinit var btnMenosPeso : FloatingActionButton
    private lateinit var btnCalcular : Button
    //--------------------------------------


    //un companion object es un objeto donde cualquier programa/paquete/clase puede acceder,
    //todo lo que se almacene adentro puede compartirse
    companion object{
    const val IMC_KEY = "current_Imc"
    }
    //--------------------------------------


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        //-----------------------
        //Se inicializa tanto los componentes como los escuchadores de inputs
        initComponets()
        initListeners()
        initUi()
        //-----------------------
    }

    //Se seleccionan los componentes
    private fun initComponets() {

        btnHombre = findViewById<CardView>(R.id.btnHombre)
        btnMujer = findViewById<CardView>(R.id.btnMujer)
        valorAltura = findViewById<TextView>(R.id.valorAltura)
        rsAltura = findViewById<RangeSlider>(R.id.rsAltura)
        valorPeso = findViewById<TextView>(R.id.valorPeso)
        valorEdad = findViewById<TextView>(R.id.valorEdad)
        btnMasEdad = findViewById<FloatingActionButton>(R.id.plusAge)
        btnMenosEdad = findViewById<FloatingActionButton>(R.id.minusAge)
        btnMasPeso = findViewById<FloatingActionButton>(R.id.plusWeight)
        btnMenosPeso = findViewById<FloatingActionButton>(R.id.minusWeight)
        btnCalcular = findViewById<Button>(R.id.btnCalcular)
    }
    //--------------------------------------

    //Se establecen los escuchadores de inputs
    private fun initListeners() {
        btnHombre.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        btnMujer.setOnClickListener{
            changeGender()
            setGenderColor()
        }

        //Cuando un valor no lo vamos a utilizar se coloca una barra baja
        rsAltura.addOnChangeListener { _, value, _ ->
            val decimalformat = DecimalFormat("#.##")
            var resultAltura = decimalformat.format(value)
            valorAltura.text = "${resultAltura}  Cm"
            currentAltura = resultAltura.toInt()
        }

        //--------------------------------------

        btnMasEdad.setOnClickListener{
            currentEdad +=1
            setEdad(currentEdad)
        }
        btnMenosEdad.setOnClickListener{
            currentEdad -=1
            setEdad(currentEdad)
        }
        btnMasPeso.setOnClickListener{
            currentPeso += 1
            setPeso(currentPeso)
        }
        btnMenosPeso.setOnClickListener{
            currentPeso -=1
            setPeso(currentPeso)
        }
        btnCalcular.setOnClickListener(){
            currentImc = calcularIMC(currentPeso,currentEdad,currentAltura)
            //REDIRIGIR A IMC RESULT
            navigateToResult()
            //--------------------------------------
        }
    }


    //--------------------------------------

    //Se cambia las variables (isMaleSelected, isFemaleSelected) de true a false de acuerdo a lo que se seleccione
    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }
    //--------------------------------------

    //Se setea el color de acuerdo a lo seleccionado por el usuario
    private fun setGenderColor(){
        btnHombre.setCardBackgroundColor(getBackgorundColor(isMaleSelected))
        btnMujer.setCardBackgroundColor(getBackgorundColor(isFemaleSelected))
    }
    //--------------------------------------

    //Se obtienen los colores de acuerdo la referencia utilizada en la ruta colors.xml
    private fun getBackgorundColor(isSelectedComponent:Boolean):Int{
        val Color = if(isSelectedComponent){
            R.color.background_selected
        }else{
            R.color.background2
        }
        //Se da contexto para que en vez de devolver un string, se devuelva un int
        return ContextCompat.getColor(this,Color)
        //--------------------------------------

    }
    //--------------------------------------


    private fun initUi() {
        setGenderColor()
    }


    // se setean tanto la edad como el peso en el frontend
    private fun setEdad(currentEdad:Int) {
        valorEdad.text = currentEdad.toString()
    }
    private fun setPeso(currentPeso:Int) {
        valorPeso.text = "${currentPeso.toString()} kg"

    }
    //-----------------------------------------------

    private fun calcularIMC(currentPeso: Int,currentEdad: Int,currentAltura:Int):Double {
        val IMC = currentPeso.toDouble()/(currentAltura.toDouble()/100 * currentAltura.toDouble()/100)
        var imcformat = DecimalFormat("#.##")
        return imcformat.format(IMC).toDouble()
    }

    //REDIRIGIR A IMC RESULT
    private fun navigateToResult(){
        val intent = Intent(this,ImcResultActivity::class.java)
        intent.putExtra(IMC_KEY,currentImc)
        startActivity(intent)
    }
    //-----------------------------------------------

}