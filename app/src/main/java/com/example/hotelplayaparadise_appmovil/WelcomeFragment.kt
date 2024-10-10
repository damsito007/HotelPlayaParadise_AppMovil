package com.example.hotelplayaparadise_appmovil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.fragment.app.Fragment

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        // Encuentra el TextView en el fragmento
        val welcomeTextView = view.findViewById<TextView>(R.id.welcomeTextView)

        // Configura la animación: Aparece lentamente (fade-in)
        val fadeInAnimation = AlphaAnimation(0.0f, 1.0f).apply {
            duration = 2000 // duración de la animación en milisegundos
            fillAfter = true // el texto permanece visible después de la animación
        }

        // Inicia la animación en el TextView
        welcomeTextView.startAnimation(fadeInAnimation)

        return view
    }
}
