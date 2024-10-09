package com.example.hotelplayaparadise_appmovil

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelplayaparadise_appmovil.databinding.FragmentConsulta1Binding
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.google.gson.Gson

class Consulta1 : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentConsulta1Binding? = null
    private val binding get() = _binding!!

    // Lista de datos para el RecyclerView
    private val dataList = mutableListOf<ApiConsulta1>()

    // Adapter para RecyclerView
    private lateinit var adapter: ApiAdapterConsult1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Usamos ViewBinding para inflar el layout
        _binding = FragmentConsulta1Binding.inflate(inflater, container, false)
        val view = binding.root

        // Configurar RecyclerView
        setupRecyclerView()

        // Hacer la solicitud a la API al hacer clic en el botón


        fetchDataFromApi()


        return view


    }



    private fun setupRecyclerView() {
        // Inicializamos el adaptador y configuramos el RecyclerView
        adapter = ApiAdapterConsult1(dataList)  // Usa tu lista global
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

    }

    private fun fetchDataFromApi() {
        // Muestra el ProgressBar
        binding.progressBar.visibility = View.VISIBLE

        // URL de la API
        val url = "https://0fdkzrqz-5069.use.devtunnels.ms/diasOcupacion_Habitaciones_x_Temporada_and_clientes"

        // Hacemos la petición GET usando Fuel
        Fuel.get(url).responseString { _, _, result ->
            // Oculta el ProgressBar al finalizar la solicitud
            binding.progressBar.visibility = View.GONE

            when (result) {
                is Result.Failure -> {
                    // Manejar errores en la petición
                    val ex = result.getException()
                    Log.e("API_ERROR", "Error al hacer la solicitud: ${ex.message}")
                    Toast.makeText(context, "Error al obtener datos", Toast.LENGTH_SHORT).show()
                }
                is Result.Success -> {
                    // Procesar la respuesta JSON
                    val data = result.get()
                    Log.d("API_RESPONSE", "Respuesta de la API: $data")

                    // Usamos Gson para convertir el JSON en una lista de ApiResponse
                    try {
                        val gson = Gson()
                        val apiResponseList = gson.fromJson(data, Array<ApiConsulta1>::class.java).toList()

                        // Limpiamos la lista y añadimos los nuevos datos
                        dataList.clear()
                        dataList.addAll(apiResponseList)

                        // Notificamos al adaptador que los datos han cambiado
                        adapter.notifyDataSetChanged()

                        Toast.makeText(context, "Datos obtenidos exitosamente", Toast.LENGTH_SHORT).show()

                    } catch (e: Exception) {
                        Log.e("JSON_ERROR", "Error al convertir el JSON: ${e.message}")
                        Toast.makeText(context, "Error al procesar los datos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Consulta1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

