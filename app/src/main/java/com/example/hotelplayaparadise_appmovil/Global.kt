package com.example.hotelplayaparadise_appmovil

data class ApiConsulta1(val count: Int, val name: String, val age: Int)

// Lista global para almacenar los resultados
var dataList: MutableList<ApiConsulta1> = mutableListOf()
