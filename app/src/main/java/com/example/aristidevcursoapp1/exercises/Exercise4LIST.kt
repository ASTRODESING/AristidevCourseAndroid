package com.example.aristidevscurso.exercises

fun main (){
    inmutableList()
}
fun inmutableList(){
    val readOnly: List<String> = listOf("Lunes","Martes","Miercoles")
    println(readOnly.size)
    println(readOnly)
    println(readOnly.last())
    println(readOnly.first())

    /* It es a iteracion que utiliza la funcion para recorrer*/
    val example = readOnly.filter { it.contains("a") }
    println("----------------------------------********---------------------------")
    println(example)
    readOnly.forEach{ weekday -> println(weekday) }
}