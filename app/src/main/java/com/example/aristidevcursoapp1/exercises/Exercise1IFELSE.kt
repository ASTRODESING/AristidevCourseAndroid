package com.example.aristidevscurso.exercises

fun main(){
    val morningNotification: Int = 51
    val eveningNotification: Int = 156
    println(printNotificacionSumary(morningNotification))
    println(printNotificacionSumary(eveningNotification))

}
fun printNotificacionSumary(numberOfMessages:Int){
     //Codigo
    if(numberOfMessages < 99){
        println("Tienes $numberOfMessages Notificaciones")
    } else{
        println("Tienes +99 Notificaciones")
    }
}