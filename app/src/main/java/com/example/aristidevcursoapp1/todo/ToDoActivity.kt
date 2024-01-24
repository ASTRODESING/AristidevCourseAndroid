package com.example.aristidevcursoapp1.todo

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aristidevcursoapp1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoActivity : AppCompatActivity() {

    private val tasks = mutableListOf(
        Task("Prueba Buisness", TaskCategories.Business),
        Task("Prueba Personal", TaskCategories.Personal),
        Task("Prueba Other", TaskCategories.Other)
    )

    private val categories = listOf(
        TaskCategories.Business,
        TaskCategories.Personal,
        TaskCategories.Other
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategorieAdapter
    private lateinit var rvTask: RecyclerView
    private lateinit var tasksAdapter: TaskAdapter
    private lateinit var addTask: FloatingActionButton
    private lateinit var dialogAddTask: Button
    private lateinit var etNuevaTarea: EditText
    private lateinit var rgCategoria: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        /*startListeners()*/
        initComponents()
        initUI()
        initListeners()


    }

    private fun initListeners() {
        addTask.setOnClickListener() {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        dialogAddTask = dialog.findViewById(R.id.btnAnadirTarea)
        etNuevaTarea = dialog.findViewById(R.id.etTask)
        rgCategoria = dialog.findViewById(R.id.rgCategories)

        dialogAddTask.setOnClickListener() {

            val selectedCategorie = rgCategoria.checkedRadioButtonId
            val currentTextTask = etNuevaTarea.text.toString()

            if (currentTextTask.isNotEmpty()) {

                val selectedButton: RadioButton = rgCategoria.findViewById(selectedCategorie)

                val currentCategory: TaskCategories = when (selectedButton.text) {
                    "Negocios" -> TaskCategories.Business
                    "Personal" -> TaskCategories.Personal
                    else -> TaskCategories.Other
                }

                tasks.add(Task(currentTextTask, currentCategory))
                updateTasks()
                dialog.hide()
            }

        }





        dialog.show()
    }

    private fun initUI() {
        categoriesAdapter = CategorieAdapter(categories) {position -> updateCategories(position)}
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TaskAdapter(tasks) { position -> onItemSelected(position) }
        rvTask.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTask.adapter = tasksAdapter
    }

    /*
        private fun startListeners() {
            TODO("Not yet implemented")
        }
    */
    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTask = findViewById(R.id.rvTasks)
        addTask = findViewById(R.id.fabAddTask)

    }

    private fun updateTasks() {
        val selectedCategories : List<TaskCategories> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.categorie) }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }

    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }
    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }
}