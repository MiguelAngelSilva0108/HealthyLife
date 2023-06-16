package com.chenao.healthylife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        postToList()

        val view_pager2 = findViewById<ViewPager2>(R.id.view_pager2)
        view_pager2.adapter = ViewPagerAdapter(titlesList, descList, imagesList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)

        val btn_fake_swipe = findViewById<Button>(R.id.btn_fake_swipe)
        val btn_volver = findViewById<Button>(R.id.btn_volver)
        btn_volver.alpha = 0f // Establecer la opacidad inicialmente en 0 (invisible)
        btn_fake_swipe.setOnClickListener {
            val currentItem = view_pager2.currentItem
            if (currentItem < titlesList.size - 1) {
                view_pager2.setCurrentItem(currentItem + 1, true)

                if (currentItem == 0) {
                    btn_volver.animate().alpha(1f).duration = 300 // Mostrar el botón "Volver"
                }
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        // Agregar listener al botón "Volver"
        btn_volver.setOnClickListener {
            if (view_pager2.currentItem > 0) {
                view_pager2.setCurrentItem(view_pager2.currentItem - 1, true)
            }
        }
    }

    private fun addToList(title: String, description: String, image: Int) {
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList() {
        addToList("Healthylife", "Conoce nuestra app y empieza a tener una vida saludable", R.drawable.logo)
        addToList("Control de peso", "Lleva un control de tu progreso y recibe recordatorios de pesarte", R.drawable.bascula)
        addToList("Control de calorias", "Analiza los alimentos que consumes y lleva un conteo de calorías de acuerdo a tus objetivos", R.drawable.calorias)
        addToList("Dietas", "Te sugeriremos dietas de acuerdo a tu actividad física y preferencias", R.drawable.dieta)
        addToList("Sugerencias de rutinas", "Organiza tus rutinas de entrenamiento y hazlo un hábito", R.drawable.musculo)
        addToList("Comienza hoy", "No esperes más, regístrate y ten el cuerpo que siempre has deseado", R.drawable.objetivos)
    }
}


