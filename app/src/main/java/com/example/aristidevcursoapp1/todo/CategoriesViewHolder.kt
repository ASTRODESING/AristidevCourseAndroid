package com.example.aristidevcursoapp1.todo

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.aristidevcursoapp1.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvCategorieName:TextView = view.findViewById(R.id.categorieName)
    private val divider:View = view.findViewById(R.id.divider)
    private val viewContainer:CardView = view.findViewById(R.id.viewContainer)

    fun render(taskCategories: TaskCategories, onItemSelected: (Int) -> Unit){

        val color = if (taskCategories.isSelected){
            R.color.background_selected
        }else{
            R.color.background2_todo
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(tvCategorieName.context, color))
        itemView.setOnClickListener{onItemSelected(layoutPosition)}

        when(taskCategories){
            TaskCategories.Business -> {
                tvCategorieName.text="Negocios"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.negocios))
            }
            TaskCategories.Personal -> {
                tvCategorieName.text="Personal"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.personal))
            }
            TaskCategories.Other -> {
                tvCategorieName.text="Otros"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.otros))
            }

        }
    }
}