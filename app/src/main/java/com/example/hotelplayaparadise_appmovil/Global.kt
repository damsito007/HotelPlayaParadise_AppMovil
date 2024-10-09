package com.example.hotelplayaparadise_appmovil

import com.google.gson.annotations.SerializedName

data class ApiConsulta1(
    @SerializedName("Tipo Habitacion") val tipoHabitacion: String,
    @SerializedName("Temporada") val temporada: String,
    @SerializedName("Nombre Clientes") val nombreClientes: String,
    @SerializedName("Dias Ocupacion") val diasOcupacion: Int
)

// Lista global para almacenar los resultados
var dataList: MutableList<ApiConsulta1> = mutableListOf()
