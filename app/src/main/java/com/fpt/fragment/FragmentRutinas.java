package com.fpt.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenao.healthylife.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentRutinas extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String param1;
    private String param2;

    public FragmentRutinas() {
        // Required empty public constructor
    }

    public static FragmentRutinas newInstance(String param1, String param2) {
        FragmentRutinas fragment = new FragmentRutinas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView recyclerView;
    List<Versions> versionsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            param1 = getArguments().getString(ARG_PARAM1);
            param2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rutinas, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        initData();
        setRecyclerView();

        return rootView;
    }

    private void setRecyclerView() {
        VersionsAdapter versionsAdapter = new VersionsAdapter(versionsList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        versionsList = new ArrayList<>();

        versionsList.add(new Versions("Pierna", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con peso muerto por 3 series de 40 repeticiones, ligeras.\n\n" +
                        "• Primer set:\n" +
                        "   - Peso muerto olímpico 10 reps x 4 series\n" +
                        "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                        "• Segundo set:\n" +
                        "   - Sentadilla profunda x 12 reps x 4 series\n" +
                        "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.pierna,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con peso muerto por 3 series de 40 repeticiones, ligeras.\n\n" +
                "• Primer set:\n" +
                "   - Extensión más sentadilla abierto y cerrado con barra 15 reps\n" +
                "   - Desplantes con leg curl 15 reps\n\n" +
                "• Segundo set:\n" +
                "   - Leg curl acostado con mancuerna 15 reps\n" +
                "   - Elevación de talón y costurera 20 reps", R.drawable.cuadricep));

        //bicep
     versionsList.add(new Versions("Bicep", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con curl de biceps por 3 series de 40 repeticiones, ligeras.\n\n" +
                        "• Primer set:\n" +
                        "   - Curl de bíceps barra Z 15 reps\n" +
                        "   - Curl barra romana 15 reps\n\n" +
                        "• Segundo set:\n" +
                        "   - Curl araña 15 reps\n" +
                        "   - Curl invertido 15 reps", R.drawable.bicep,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con curl de biceps por 3 series de 40 repeticiones, ligeras.\n\n" +
                "• Primer set:\n" +
                "   - Curl de bíceps 15 reps" +
                "   - Martillos 15 reps \n\n" +
                "• Segundo set:\n" +
                "   - Curl máquina 15 reps\n" +
                "   - Curl invertido 15 reps", R.drawable.bicep));

        //pecho
    versionsList.add(new Versions("Pecho", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con pesos ligeros, y movientos para hombro.\n\n" +
                        "• Primer set:\n" +
                        "   - Máquina de pecho 15 reps\n" +
                        "   - Press barra horizontal 15 reps\n\n" +
                        "• Segundo set:\n" +
                        "   - Cross Over 25 reps\n" +
                        "   - Pull Over 15 reps", R.drawable.peck,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con pesos ligeros, y movimientos para hombro.\n\n" +
                "• Primer set:\n" +
                "   - Press con barra en banco horizontal 15 reps\n" +
                "   - Cross Over pirámide estática (15-12-8 reps)\n\n" +
                "• Segundo set:\n" +
                "   - Press inclinado con mancuerna 15 reps\n" +
                "   - Press plano con mancuernas más pull over 15 reps.", R.drawable.pecho));

        //espalda
        versionsList.add(new Versions("Espalda", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con peso muerto y remos, ligero.\n\n" +
                        "• Primer set:\n" +
                        "   - Jalón al frente cerrado y abierto 15 reps\n" +
                        "   - Remo con barra más triángulo 15 reps\n\n" +
                        "• Segundo set:\n" +
                        "   - Remo sentado 15 reps\n" +
                        "   - Remo T con barra 15 reps", R.drawable.espalda,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con peso muerto y remos, ligero.\n\n" +
                "• Primer set:\n" +
                "   - Remo con mancuerna 20 reps \n" +
                "   - Jalón abierto más jalón cerrado 15 reps\n\n" +
                "• Segundo set:\n" +
                "   - Holándes 15 reps\n" +
                "   - Híperextensión para espalda baja 25 reps", R.drawable.atras));

        //hombro
  versionsList.add(new Versions("Pierna", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con press de hombro y pajaros, ligero.\n\n" +
                        "• Primer set:\n" +
                        "   - Press de hombro de pie 15 reps\n" +
                        "   - Laterales con mancuerna 15 reps \n\n" +
                        "• Segundo set:\n" +
                        "   - Press mancuerna cerrado sentado 15 reps\n" +
                        "   - Pájaros 12-15 reps", R.drawable.hombro,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con press de hombro y pajaros, ligero.\n\n" +
                "• Primer set:\n" +
                "   - Press de hombro mancuernas tres posiciones (press Arnold+press frontal+press normal sin bajar las mancuernas)\n" +
                "   - Pájaros 15 reps\n\n" +
                "• Segundo set:\n" +
                "   - Frontal con laterales 5-5 (repeticiones de una a 5 en orden ascendente)\n" +
                "   - Lateral inclinado a una mano 15 reps", R.drawable.hmb));

        //tricep
       versionsList.add(new Versions("Tricep", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con cuerda y press de hombro.\n\n" +
                        "• Primer set:\n" +
                        "   - Extensión con barra polea alta 15 reps\n" +
                        "   - Press francés a una mano individual prexaustivo 15 reps\n\n" +
                        "• Segundo set:\n" +
                        "   - Copa a dos manos 15 reps\n" +
                        "   - Patada de tríces en polea 15 reps", R.drawable.triceps,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con cuerda y pressde hombro.\n\n" +
                "• Primer set:\n" +
                "   - Francés en pirámide estática (15-12-10-5 reps)\n" +
                "   - más extensión con cuerda 15 reps\n\n" +
                "• Segundo set:\n" +
                "   - Copa a una mano 15 reps\n" +
                "   - Press francés mancuerna más polea con agarre invertido 15 reps ", R.drawable.tri));

    }
}
