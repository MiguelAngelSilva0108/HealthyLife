package com.chenao.healthylife

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FormPagerAdapter(private val formList: List<Int>) : RecyclerView.Adapter<FormPagerAdapter.FormViewHolder>() {

    inner class FormViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            when (position) {
                1 -> bindObjetivo()
                2 -> bindPesoObjetivo()
                3 -> bindSexo()
                4 -> bindActividad()
                5 -> bindPesoActual()
                6 -> bindEstatura()
                // Agrega más casos según tus necesidades para los otros formularios
            }
        }

        private fun bindObjetivo() {
            val radioPerderPeso = itemView.findViewById<RadioButton>(R.id.radioPerderPeso)
            val radioGanarPeso = itemView.findViewById<RadioButton>(R.id.radioGanarPeso)

            // Verifica si el RadioButton de "Perder peso" está seleccionado
            val objetivo = if (radioPerderPeso.isChecked) {
                "Perder peso"
            } else {
                "Ganar peso"
            }

            // Guarda el valor en Firestore
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            val firestore = FirebaseFirestore.getInstance()
            uid?.let {
                val datos = hashMapOf(
                    "objetivo" to objetivo
                )
                firestore.collection("usuarios").document(it).set(datos)
            }
        }


        private fun bindPesoObjetivo() {
            val pesoObjetivo = itemView.findViewById<EditText>(R.id.PesoObjetivo)
            val pesoObjetivoValue = pesoObjetivo.text.toString()

            // Guarda el valor en Firestore
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            val firestore = FirebaseFirestore.getInstance()
            uid?.let {
                val datos = hashMapOf(
                    "Peso_Objetivo" to pesoObjetivoValue
                )
                firestore.collection("usuarios").document(it).set(datos)
            }
        }

        private fun bindSexo() {
            val radioMujer = itemView.findViewById<RadioButton>(R.id.radioMujer)
            val radioHombre = itemView.findViewById<RadioButton>(R.id.radioHombre)

            // Obtén el valor seleccionado
            val sexo = if (radioMujer.isChecked) {
                "Mujer"
            } else {
                "Hombre"
            }

            // Guarda el valor en Firestore
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            val firestore = FirebaseFirestore.getInstance()
            uid?.let {
                val datos = hashMapOf(
                    "sexo" to sexo
                )
                firestore.collection("usuarios").document(it).set(datos)
            }
        }

        private fun bindActividad() {
            val sedentario = itemView.findViewById<RadioButton>(R.id.Sedentario)
            val actividadBaja = itemView.findViewById<RadioButton>(R.id.ActividadBaja)
            val activo = itemView.findViewById<RadioButton>(R.id.Activo)
            val muyActivo = itemView.findViewById<RadioButton>(R.id.MuyActivo)

            // Obtén el valor seleccionado
            val actividad = when {
                sedentario.isChecked -> "Sedentario"
                actividadBaja.isChecked -> "Actividad Baja"
                activo.isChecked -> "Activo"
                muyActivo.isChecked -> "Muy Activo"
                else -> ""
            }

            // Guarda el valor en Firestore
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            val firestore = FirebaseFirestore.getInstance()
            uid?.let {
                val datos = hashMapOf(
                    "actividad" to actividad
                )
                firestore.collection("usuarios").document(it).set(datos)
            }
        }

        private fun bindPesoActual() {
            val pesoActual = itemView.findViewById<EditText>(R.id.PesoActual)
            val pesoActualValue = pesoActual.text.toString()

            // Guarda el valor en Firestore
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            val firestore = FirebaseFirestore.getInstance()
            uid?.let {
                val datos = hashMapOf(
                    "PesoActual" to pesoActualValue
                )
                firestore.collection("usuarios").document(it).set(datos)
            }
        }

        private fun bindEstatura() {
            val estatura = itemView.findViewById<EditText>(R.id.Estatura)
            val estaturaValue = estatura.text.toString()

            // Guarda el valor en Firestore
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            val firestore = FirebaseFirestore.getInstance()
            uid?.let {
                val datos = hashMapOf(
                    "Estatura" to estaturaValue
                )
                firestore.collection("usuarios").document(it).set(datos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return FormViewHolder(view)
    }

    override fun getItemCount(): Int {
        return formList.size
    }

    override fun getItemViewType(position: Int): Int {
        return formList[position]
    }

    override fun onBindViewHolder(holder: FormViewHolder, position: Int) {
        holder.bind(position)
    }
}

