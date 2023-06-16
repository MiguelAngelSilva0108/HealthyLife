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

public class FragmentDietas extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String param1;
    private String param2;

    public FragmentDietas() {
        // Required empty public constructor
    }

    public static FragmentDietas newInstance(String param1, String param2) {
        FragmentDietas fragment = new FragmentDietas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView recyclerView;
    List<VersionsDieta> versionsList;

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
        VersionsAdapterDieta versionsAdapterDieta = new VersionsAdapterDieta(versionsList);
        recyclerView.setAdapter(versionsAdapterDieta);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        versionsList = new ArrayList<>();

        versionsList.add(new VersionsDieta("Pierna", "Primer entrenamiento", "Principiantes",
                "• Realiza un breve calentamiento con peso muerto por 3 series de 40 repeticiones, ligeras.\n\n" +
                        "• Primer set:\n" +
                        "   - Peso muerto olímpico 10 reps x 4 series\n" +
                        "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                        "• Segundo set:\n" +
                        "   - Sentadilla profunda x 12 reps x 4 series\n" +
                        "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.pierna,
                "texto", "texto", "• Realiza un breve calentamiento con peso muerto por 3 series de 40 repeticiones, ligeras.\n\n" +
                "• Primer set:\n" +
                "   - Peso muerto olímpico 10 reps x 4 series\n" +
                "   - Peso muerto a una pierna con mancuerna 20reps x 4 series\n\n" +
                "• Segundo set:\n" +
                "   - Sentadilla profunda x 12 reps x 4 series\n" +
                "   - Prensa pies arriba juntos 15 reps x 4 series", R.drawable.cuadricep));

        versionsList.add(new VersionsDieta("Brazo", "1", "1.0", "Primer set: Curl de bíceps barra Z 15rep x 4 series, curl barra romana, Segundo set: Curl araña más curl invertido 15rep x 4 series",
                R.drawable.cuadricep, "", "", "", R.drawable.cuadricep));
        versionsList.add(new VersionsDieta("Pecho", "1", "1.0", "Primer set: Press con mancuerna en banco horizontal 15rep x 4 series más press máquina más pull over 15reps x 4 series, Segundo set: Press inclinado usando mancuernas 15reps x 4 series, Cristos banco plano 15reps x 4 series",
                R.drawable.cuadricep, "", "", "", R.drawable.cuadricep));
        versionsList.add(new VersionsDieta("Espalda", "1", "1.0", "Jalon al frente abierto más remo mancuerna 15reps x 4 series, Remo con barra más jalón individual polea alta 15reps x 4 series, Hiper-extensión más dominadas al fallo",
                R.drawable.cuadricep, "", "", "", R.drawable.cuadricep));
        versionsList.add(new VersionsDieta("Hombro", "1", "1.0", "Press de hombro con barra más laterales con mancuerna 15reps x 4 series, Press con mancuerna con pájaros acostado más a una mano con mancuernas (pajaro) 15reps x 4 series, Press a una mano de pie más frontal con mancuerna 15reps x 4 series",
                R.drawable.cuadricep, "", "", "", R.drawable.cuadricep));
        versionsList.add(new VersionsDieta("Tricep", "1", "1.0", "Extensión con barra polea alta más copa a dos manos con mancuernas separadas, Press francés prexhaustivo (de 1 a 5 más 5 dobles) más patadas de trícep",
                R.drawable.cuadricep, "", "", "", R.drawable.cuadricep));
    }
}
