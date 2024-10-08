package com.example.hotelplayaparadise_appmovil

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelplayaparadise_appmovil.databinding.FragmentConsulta3Binding
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.google.gson.Gson

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Consulta3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Consulta3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //	_binding es una variable privada que almacena el objeto de enlace
    // para el diseño del fragmento (FragmentProductoRegionBinding).
    private var _binding: FragmentConsulta3Binding? = null

    // binding es una propiedad que expone ese objeto, asegurándose de que nunca sea nulo (usando !!).
    private val binding get() = _binding!!

    // Lista de datos para el RecyclerView
    private val dataList = mutableListOf<DatosHotel>()

    // Adapter para RecyclerView
    private lateinit var adapter: ApiAdapterConsult3

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
        // Inflate the layout for this fragment
        _binding = FragmentConsulta3Binding.inflate(inflater,container,false)
        val view = binding.root

        // Configurar RecyclerView
        setupRecyclerView()

        // Hacer la solicitud a la API al hacer clic en el botón
        binding.ObtenerDatos.setOnClickListener(){
            fetchDataFromApi()
        }

        return view
    }//final del view

    private fun setupRecyclerView() {
        // Inicializamos el adaptador y configuramos el RecyclerView
        adapter = ApiAdapterConsult3(dataList)  // Usa tu lista global
        binding.recyclerViewConsulta3.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewConsulta3.adapter = adapter

    }

    private fun fetchDataFromApi() {
        // URL de la API
        val url = "https://0fdkzrqz-5069.use.devtunnels.ms/diasOcupacion_Habitaciones_x_Temporada_and_clientes"

        // Hacemos la petición GET usando Fuel
        Fuel.get(url).responseString { _, _, result ->
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
                        val apiResponseList = gson.fromJson(data, Array<DatosHotel>::class.java).toList()

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
    }//fin de la funcion

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Consulta3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Consulta3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}