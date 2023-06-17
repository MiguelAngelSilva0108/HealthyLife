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
                "   - Peso muerto olímpico 10 reps x 4 series\n" +
                "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                "• Segundo set:\n" +
                "   - Sentadilla profunda x 12 reps x 4 series\n" +
                "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.cuadricep));

        //bicep
     versionsList.add(new Versions("Bicep", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con curl de biceps por 3 series de 40 repeticiones, ligeras.\n\n" +
                        "• Primer set:\n" +
                        "   - Peso muerto olímpico 10 reps x 4 series\n" +
                        "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                        "• Segundo set:\n" +
                        "   - Sentadilla profunda x 12 reps x 4 series\n" +
                        "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.pierna,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con curl de biceps por 3 series de 40 repeticiones, ligeras.\n\n" +
                "• Primer set:\n" +
                "   - Peso muerto olímpico 10 reps x 4 series\n" +
                "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                "• Segundo set:\n" +
                "   - Sentadilla profunda x 12 reps x 4 series\n" +
                "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.cuadricep));

        //pecho
    versionsList.add(new Versions("Pecho", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con pesos ligeros, y movientos para hombro.\n\n" +
                        "• Primer set:\n" +
                        "   - Peso muerto olímpico 10 reps x 4 series\n" +
                        "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                        "• Segundo set:\n" +
                        "   - Sentadilla profunda x 12 reps x 4 series\n" +
                        "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.pierna,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con pesos ligeros, y movimientos para hombro.\n\n" +
                "• Primer set:\n" +
                "   - Peso muerto olímpico 10 reps x 4 series\n" +
                "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                "• Segundo set:\n" +
                "   - Sentadilla profunda x 12 reps x 4 series\n" +
                "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.cuadricep));

        //espalda
        versionsList.add(new Versions("Espalda", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con peso muerto y remos, ligero.\n\n" +
                        "• Primer set:\n" +
                        "   - Peso muerto olímpico 10 reps x 4 series\n" +
                        "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                        "• Segundo set:\n" +
                        "   - Sentadilla profunda x 12 reps x 4 series\n" +
                        "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.pierna,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con peso muerto y remos, ligero.\n\n" +
                "• Primer set:\n" +
                "   - Peso muerto olímpico 10 reps x 4 series\n" +
                "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                "• Segundo set:\n" +
                "   - Sentadilla profunda x 12 reps x 4 series\n" +
                "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.cuadricep));

        //hombro
  versionsList.add(new Versions("Pierna", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con press de hombro y pajaros, ligero.\n\n" +
                        "• Primer set:\n" +
                        "   - Peso muerto olímpico 10 reps x 4 series\n" +
                        "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                        "• Segundo set:\n" +
                        "   - Sentadilla profunda x 12 reps x 4 series\n" +
                        "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.pierna,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con press de hombro y pajaros, ligero.\n\n" +
                "• Primer set:\n" +
                "   - Peso muerto olímpico 10 reps x 4 series\n" +
                "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                "• Segundo set:\n" +
                "   - Sentadilla profunda x 12 reps x 4 series\n" +
                "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.cuadricep));

        //tricep
       versionsList.add(new Versions("Tricep", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con cuerda y press de hombro.\n\n" +
                        "• Primer set:\n" +
                        "   - Peso muerto olímpico 10 reps x 4 series\n" +
                        "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                        "• Segundo set:\n" +
                        "   - Sentadilla profunda x 12 reps x 4 series\n" +
                        "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.pierna,
                "Segunda rutina", "Intermedio", "• Realiza un breve calentamiento con cuerda y pressde hombro.\n\n" +
                "• Primer set:\n" +
                "   - Peso muerto olímpico 10 reps x 4 series\n" +
                "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                "• Segundo set:\n" +
                "   - Sentadilla profunda x 12 reps x 4 series\n" +
                "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.cuadricep));

    }
}
