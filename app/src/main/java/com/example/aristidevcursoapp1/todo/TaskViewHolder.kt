package com.example.aristidevcursoapp1.todo

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.aristidevcursoapp1.R

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTasks: TextView = view.findViewById(R.id.tvTask)
    private val cbTasks: CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Task) {

        if (task.isSelected) {
            tvTasks.paintFlags = tvTasks.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTasks.paintFlags = tvTasks.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        cbTasks.isChecked = task.isSelected
        tvTasks.text = task.name
        val color = when (task.categorie){
            TaskCategories.Business -> R.color.negocios
            TaskCategories.Other -> R.color.otros
            TaskCategories.Personal -> R.color.personal
        }
        cbTasks.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(tvTasks.context,color))


    }
}