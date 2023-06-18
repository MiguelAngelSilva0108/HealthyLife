package com.fpt.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.chenao.healthylife.LoginActivity
import com.chenao.healthylife.R
import com.google.firebase.auth.FirebaseAuth

class FragmentPerfil : Fragment() {

    private lateinit var correoUsuarioTextView: TextView
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        correoUsuarioTextView = view.findViewById(R.id.correousuario)
        val signOutButton: Button = view.findViewById(R.id.signOutButton)
        val spinnerOpciones: Spinner = view.findViewById(R.id.spinnerOpciones)

        firebaseAuth = FirebaseAuth.getInstance()
        val currentUser = firebaseAuth.currentUser
        val email = currentUser?.email

        correoUsuarioTextView.text = email

        signOutButton.setOnClickListener {
            firebaseAuth.signOut()
            // Navegar a la pantalla de inicio de sesión después de cerrar sesión
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish() // Opcionalmente, finalizar la actividad actual
        }

        // Crear una lista de opciones para el Spinner
        val opciones = listOf("Perder Peso", "Ganar peso")

        // Crear un ArrayAdapter usando la lista de opciones y un diseño predeterminado
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opciones)

        // Especificar el diseño que se usará cuando se desplieguen las opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Establecer el adaptador en el Spinner
        spinnerOpciones.adapter = adapter

        // Manejar el evento de selección del Spinner
        spinnerOpciones.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val opcionSeleccionada = opciones[position]
                // Aquí puedes realizar las acciones necesarias según la opción seleccionada
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Manejar el caso en el que no se seleccione ninguna opción
            }
        }

        return view
    }
}
