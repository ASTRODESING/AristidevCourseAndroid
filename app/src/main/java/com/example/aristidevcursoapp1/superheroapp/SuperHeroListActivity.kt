package com.example.aristidevcursoapp1.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import com.example.aristidevcursoapp1.databinding.ActivitySuperHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// API TOKEN 7206958199369604

class SuperHeroListActivity : AppCompatActivity() {

    //se crea la variable binding para acceder a todos los elementos del xml de una manera mas
    //simple y facil
    private lateinit var binding: ActivitySuperHeroListBinding
    //--------------------------------------------------------------------------
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //se infla la variable con el layout que queremos para acceder a sus componentes
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        //--------------------------------------------------------------------------

        setContentView(binding.root)
        retrofit = getRetrofit()
        initUi()

    }

    private fun initUi() {

        //Se crea un listener desde el binding.searchView para que reciba el enter como
        //una llamada a una funcion
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        //--------------------------------------------------------------------------
    }

    private fun searchByName(query:String) {

        binding.progressBar.isVisible = true

        // Se utiliza el coroutine scrope para añadir un hilo adicional a la aplicacion
        //Y asi trabajar asincronamente con el hilo principal
       CoroutineScope(Dispatchers.IO).launch{

           //Retrofit ejecuta el codigo dentro del archivo ApiService.kt pasandole el query
           //que continene la string que recuperamos cuando llamamos a la funcion
           val myResponse = retrofit.create(ApiService::class.java).getSuperHeroes(query)
           //----------------------------------------------------------------------------------

           if(myResponse.isSuccessful){
               val response: SuperHeroDataResponse? = myResponse.body()
               if(response != null){
                   Log.i("ApiAdvice",response.toString())

                   //La barra de progreso es visible en el hilo principal, ningun elemento puede
                   //modificar en un hilo secundario
                   runOnUiThread{
                       binding.progressBar.isVisible = false
                   }
                   //----------------------------------------------------------------------------------
               }

           }else{
               Log.i("ApiAdvice","No Funciona!")
           }

       }
        //----------------------------------------------------------------------------------
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://www.superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}