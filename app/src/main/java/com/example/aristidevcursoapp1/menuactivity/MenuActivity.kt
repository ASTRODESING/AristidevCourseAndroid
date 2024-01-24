package com.example.aristidevcursoapp1.menuactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.aristidevcursoapp1.MainActivity
import com.example.aristidevcursoapp1.R
import com.example.aristidevcursoapp1.imccalculator.ImcActivity
import com.example.aristidevcursoapp1.superheroapp.SuperHeroListActivity
import com.example.aristidevcursoapp1.todo.ToDoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnSaludar = findViewById<AppCompatButton>(R.id.btnSaludar)
        var btnIMC = findViewById<AppCompatButton>(R.id.btnIMC)
        var btnToDo = findViewById<AppCompatButton>(R.id.btnToDo)
        var btnSuperHeroApp = findViewById<AppCompatButton>(R.id.btnSuperHeroApp)



        btnSaludar.setOnClickListener{navigateToSaludarApp()}
        btnIMC.setOnClickListener{navigateToIMC()}
        btnToDo.setOnClickListener{navigateToToDo()}
        btnSuperHeroApp.setOnClickListener{navigateToSuperHero()}


        }

    private fun navigateToSuperHero() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToToDo() {
        val intent = Intent(this, ToDoActivity::class.java)
        startActivity(intent)
    }

    fun navigateToSaludarApp(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun navigateToIMC(){
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }
    }


