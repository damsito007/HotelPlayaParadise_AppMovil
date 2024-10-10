package com.example.hotelplayaparadise_appmovil

import com.google.gson.annotations.SerializedName

// data cllas de la consulta numero 1
data class ApiConsulta1(
    @SerializedName("Tipo Habitacion") val tipoHabitacion: String,
    @SerializedName("Temporada") val temporada: String,
    @SerializedName("Nombre Clientes") val nombreClientes: String,
    @SerializedName("Dias Ocupacion") val diasOcupacion: Int
)

// Lista global para almacenar los resultados de la data class de la consulta 1
var dataList: MutableList<ApiConsulta1> = mutableListOf()


// data class de la consulta numero 2

data class Apiconsulta2(
    @SerializedName("Nombre Clientes") val nombreClientes: String,
    @SerializedName("Dias Ocupacion") val diasOcupacion: Int
)


// Lista Global para almacenar los resultados de la data class de la consulta 2
var datalist2: MutableList<Apiconsulta2> = mutableListOf()

// data class de la consulta numero 3

data class Apiconsulta3(
    @SerializedName("Metodo Reservacion") val metodoreservacion: String,
    @SerializedName("Nombre Clientes") val nombreClientes: String,
    @SerializedName("Num Mes") val nummes: String,
    @SerializedName("Precio Noche") val precionoche: Double,
    @SerializedName("Precio Paquete") val preciopaquete: Double
)

// Lista Global para almacenar los resultados de la data class de la consulta 3
var datalist3: MutableList<Apiconsulta3> = mutableListOf()