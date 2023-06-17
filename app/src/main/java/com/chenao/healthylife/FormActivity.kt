package com.chenao.healthylife

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class FormActivity : AppCompatActivity() {
    private val formList = mutableListOf<Int>() // Lista de diseños de formulario
    private lateinit var viewPager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        viewPager = findViewById(R.id.view_pager2)

        // Agrega los diseños de formulario a la lista
        formList.add(R.layout.item_form_page) // Reemplaza con el nombre del archivo XML para la página 1 del formulario
        formList.add(R.layout.item_form_page1)
        // Agrega más páginas de formulario según tus necesidades

        viewPager.adapter = FormPagerAdapter(formList)
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager)
    }
}
