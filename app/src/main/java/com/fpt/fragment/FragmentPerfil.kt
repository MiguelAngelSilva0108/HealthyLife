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
        val spinnerActividad: Spinner = view.findViewById(R.id.spinnerActividad)
        val spinnerSexo: Spinner = view.findViewById(R.id.spinnerSexo)

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

        // Crear una lista de opciones para el Spinner de objetivos
        val opciones = listOf("Perder Peso", "Ganar peso")

        // Crear un ArrayAdapter usando la lista de opciones y un diseño predeterminado
        val adapterOpciones = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opciones)

        // Especificar el diseño que se usará cuando se desplieguen las opciones
        adapterOpciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Establecer el adaptador en el Spinner de objetivos
        spinnerOpciones.adapter = adapterOpciones

        // Crear una lista de opciones para el Spinner de actividad
        val actividades = listOf("Sedentario", "Actividad Baja", "Activo", "Muy Activo")

        // Crear un ArrayAdapter usando la lista de opciones y un diseño predeterminado
        val adapterActividad = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, actividades)

        // Especificar el diseño que se usará cuando se desplieguen las opciones
        adapterActividad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Establecer el adaptador en el Spinner de actividad
        spinnerActividad.adapter = adapterActividad

        // Crear una lista de opciones para el Spinner de sexo
        val sexos = listOf("Mujer", "Hombre")

        // Crear un ArrayAdapter usando la lista de opciones y un diseño predeterminado
        val adapterSexo = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, sexos)

        // Especificar el diseño que se usará cuando se desplieguen las opciones
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Establecer el adaptador en el Spinner de sexo
        spinnerSexo.adapter = adapterSexo

        // Manejar el evento de selección del Spinner de objetivos
        spinnerOpciones.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val opcionSeleccionada = opciones[position]
                // Aquí puedes realizar las acciones necesarias según la opción seleccionada
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Manejar el caso en el que no se seleccione ninguna opción
            }
        }

        // Manejar el evento de selección del Spinner de actividad
        spinnerActividad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val actividadSeleccionada = actividades[position]
                // Aquí puedes realizar las acciones necesarias según la opción seleccionada
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Manejar el caso en el que no se seleccione ninguna opción
            }
        }

        // Manejar el evento de selección del Spinner de sexo
        spinnerSexo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val sexoSeleccionado = sexos[position]
                // Aquí puedes realizar las acciones necesarias según el sexo seleccionado
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Manejar el caso en el que no se seleccione ningún sexo
            }
        }

        return view
    }
}
