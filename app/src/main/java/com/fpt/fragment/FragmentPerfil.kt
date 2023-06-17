package com.fpt.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        return view
    }
}
