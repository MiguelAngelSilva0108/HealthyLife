package com.chenao.healthylife

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
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

        val btnFakeSwipe = findViewById<Button>(R.id.btn_fake_swipe)
        val btnVolver = findViewById<Button>(R.id.btn_volver)
        btnVolver.alpha = 0f // Establecer la opacidad inicialmente en 0 (invisible)
        btnFakeSwipe.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < formList.size - 1) {
                viewPager.setCurrentItem(currentItem + 1, true)

                if (currentItem == 0) {
                    btnVolver.animate().alpha(1f).duration = 300 // Mostrar el botón "Volver"
                }
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

// Agregar listener al botón "Volver"
        btnVolver.setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.setCurrentItem(viewPager.currentItem - 1, true)
            }
        }


        // Agrega los diseños de formulario a la lista
        formList.add(R.layout.item_form_page)
        formList.add(R.layout.item_form_page1)
        formList.add(R.layout.item_form_page2)
        formList.add(R.layout.item_form_page3)
        formList.add(R.layout.item_form_page4)
        formList.add(R.layout.item_form_page5)
        formList.add(R.layout.item_form_page6)


        // Agrega más páginas de formulario según tus necesidades

        viewPager.adapter = FormPagerAdapter(formList)
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager)

    }


}
