package com.chenao.healthylife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.chenao.healthylife.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener {
            val email = binding.signupEmail.text.toString()
            val password = binding.signupPassword.text.toString()
            val confirmPassword = binding.signupConfirm.text.toString()

            // Validar el correo electrónico
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                showError(binding.signupEmail, "Ingrese un correo válido")
                return@setOnClickListener
            }

            // Validar la contraseña
            if (!validatePassword(password)) {
                showError(binding.signupPassword, "La contraseña no cumple con los requisitos")
                return@setOnClickListener
            }

            // Validar la confirmación de contraseña
            if (confirmPassword != password) {
                showError(binding.signupConfirm, "Las contraseñas no coinciden")
                return@setOnClickListener
            }

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.loginRedirectText.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }

    private fun validatePassword(password: String): Boolean {
        val passwordRegex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#\$%^&+=!¡¿?_\\-]).{6,10}\$".toRegex()
        return passwordRegex.matches(password)
    }



    private fun showError(editText: EditText, error: String) {
        editText.error = error
        editText.requestFocus()
    }
}
