package com.example.aristidevscurso.exercises

fun main(){
    val child = 12
    val adult = 28
    val senior = 87

    val isMonday = true

    println("El ticket para persona niño es de ${ticketPrice(child,false)}$")
    println("El ticket para persona adulto es de  ${ticketPrice(adult,isMonday)}")
    println("El ticket para persona señor es de  ${ticketPrice(senior,false)}")
}
fun ticketPrice(age:Int,isMonday:Boolean): Int {
    return when (age){
        in 0..12 -> 15
        in 13 ..60 -> if (isMonday){25}else{30}
        in 60 ..100 -> 20
        else -> -1
    }
}