package com.example.hotelplayaparadise_appmovil

data class ApiConsulta1(val TipoHabitacion: String, val Temporada: String, val NombreCliente: String, val DiasOcupacion: Int)

// Lista global para almacenar los resultados
var dataList: MutableList<ApiConsulta1> = mutableListOf()
