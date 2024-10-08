package com.example.hotelplayaparadise_appmovil

// Definicion de la clase de datos
data class DatosHotel(
    val tipo_habitacion: String,
    val temporada: String,
    val nombre_cliente: String,
    val dias_ocupacion: Int
)

//Lista global para almacenar los resultados
var ListaDatos: MutableList<DatosHotel> = mutableListOf()