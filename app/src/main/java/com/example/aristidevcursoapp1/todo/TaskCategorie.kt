package com.example.aristidevcursoapp1.todo


// Aqui se van a crear objetos
sealed class TaskCategories(var isSelected : Boolean = true) {
    object Personal:TaskCategories()
    object Business:TaskCategories()
    object Other:TaskCategories()
}