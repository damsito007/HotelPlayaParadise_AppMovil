package com.example.hotelplayaparadise_appmovil

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.hotelplayaparadise_appmovil.databinding.ActivityPrincipalMenuBinding
import com.google.android.material.navigation.NavigationView

class Principal_Menu : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrincipalMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botón para abrir el menú lateral
        binding.menuButton.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        // Configurar el NavigationView
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.consulta1 -> {
                    loadFragment(Consulta1()) // Cargar Consulta1Fragment
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START) // Cerrar el menú
            true
        }


    }

    private fun loadFragment(fragment: Fragment) {
        // Cambiar el fragmento
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null) // Agregar a la pila de retroceso
        transaction.commit()
    }
}