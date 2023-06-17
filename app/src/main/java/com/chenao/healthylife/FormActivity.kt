package com.chenao.healthylife

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3
import java.util.*

class FormActivity : AppCompatActivity() {
    private val formList = mutableListOf<Int>() // Lista de diseños de formulario
    private lateinit var viewPager: ViewPager2
    private var selectedDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        viewPager = findViewById(R.id.view_pager2)

        // Agrega los diseños de formulario a la lista
        formList.add(R.layout.item_form_page)
        formList.add(R.layout.item_form_page1)
        formList.add(R.layout.item_form_page2)
        formList.add(R.layout.item_form_page3)
        formList.add(R.layout.item_form_page4)
        formList.add(R.layout.item_form_page5)
        formList.add(R.layout.item_form_page6)
        formList.add(R.layout.item_form_page7)

        // Agrega más páginas de formulario según tus necesidades

        viewPager.adapter = FormPagerAdapter(formList)
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager)

        // Obtener la vista de la página 7
        val page7 = viewPager.getChildAt(7)
        val btnDatePicker = page7.findViewById<Button>(R.id.btnDatePicker)

        // Asignar el listener al botón para abrir el DatePickerDialog
        btnDatePicker.setOnClickListener {
            showDatePickerDialog()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            // El usuario seleccionó una fecha
            selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            // Actualizar el texto del botón con la fecha seleccionada
            val page7 = viewPager.getChildAt(7)
            val btnDatePicker = page7.findViewById<Button>(R.id.btnDatePicker)
            btnDatePicker.text = "Fecha seleccionada: $selectedDate"
        }, year, month, day)

        // Muestra el DatePickerDialog
        datePickerDialog.show()
    }
}
