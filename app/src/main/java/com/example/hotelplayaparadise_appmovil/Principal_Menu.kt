package com.example.yourapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Principal_Menu : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal_menu) // Asegúrate de que el nombre del layout coincida

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        // Configura el ActionBarDrawerToggle
        toggle = ActionBarDrawerToggle(this, drawerLayout,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Habilitar el botón de navegación en la ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Manejar las selecciones del menú
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    // Acción para Dashboard
                    startActivity(Intent(this, DashboardActivity::class.java))
                }
                R.id.nav_catalogue -> {
                    // Acción para Catalogue
                    startActivity(Intent(this, CatalogueActivity::class.java))
                }
                R.id.nav_settings -> {
                    // Acción para Settings
                    startActivity(Intent(this, SettingsActivity::class.java))
                }
                R.id.nav_about -> {
                    // Acción para About
                    startActivity(Intent(this, AboutActivity::class.java))
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START) // Cierra el menú después de seleccionar un item
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Maneja el toggle del menú
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
