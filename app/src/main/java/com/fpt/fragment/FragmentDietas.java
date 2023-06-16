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
        //DESAYUNO
        versionsList.add(new VersionsDieta("Desayunos ", "Algo Ligero", "Défict calórico",
                        "\n•Desayuno 1\n" +
                        "   - Avena\n" +
                        "   - Un mix de frutos secos\n" +
                                "-Freas o plátanos\n\n" +
                                "•Desayuno 2\n"+
                                "   - Yogurt Natural\n" +
                                "   - Frutas Frescas\n" +
                                "   - 1 Cda de salvado de avena, semillas de linaza o chia\n\n"+
                                "•Desayuno 3\n"+
                                "   - Juego de frutas con 1 cdta de ajonjolí o semillas de linaza\n" +
                                "   - Una tortilla de verduras variadas\n\n" ,R.drawable.deficit,
                "Algo pesado", "SuperHábit Calórico",
                "\n•Desayuno 1\n" +
                        "   - Avena\n" +
                        "   - Un mix de frutos secos\n" +
                        "-Freas o plátanos\n\n" +
                        "•Desayuno 2\n"+
                        "   - Yogurt Natural\n" +
                        "   - Frutas Frescas\n" +
                        "   - 1 Cda de salvado de avena, semillas de linaza o chia\n\n"+
                        "•Desayuno 3\n"+
                        "   - Juego de frutas con 1 cdta de ajonjolí o semillas de linaza\n" +
                        "   - Una tortilla de verduras variadas\n\n", R.drawable.calorias));
//COMIDA
        versionsList.add(new VersionsDieta("Comida", "Algo Ligero", "Défictcalórico",
                "\n•Desayuno 1\n" +
                        "   - Avena\n" +
                        "   - Un mix de frutos secos\n" +
                        "-Freas o plátanos\n\n" +
                        "•Desayuno 2\n"+
                        "   - Yogurt Natural\n" +
                        "   - Frutas Frescas\n" +
                        "   - 1 Cda de salvado de avena, semillas de linaza o chia\n\n"+
                        "•Desayuno 3\n"+
                        "   - Juego de frutas con 1 cdta de ajonjolí o semillas de linaza\n" +
                        "   - Una tortilla de verduras variadas\n\n" ,R.drawable.deficit,
                "Algo pesado", "SuperHábit Calórico",
                "\n•Desayuno 1\n" +
                        "   - Avena\n" +
                        "   - Un mix de frutos secos\n" +
                        "-Freas o plátanos\n\n" +
                        "•Desayuno 2\n"+
                        "   - Yogurt Natural\n" +
                        "   - Frutas Frescas\n" +
                        "   - 1 Cda de salvado de avena, semillas de linaza o chia\n\n"+
                        "•Desayuno 3\n"+
                        "   - Juego de frutas con 1 cdta de ajonjolí o semillas de linaza\n" +
                        "   - Una tortilla de verduras variadas\n\n", R.drawable.calorias));
        //CENA
        versionsList.add(new VersionsDieta("Cena", "Algo Ligero", "Défictcalórico",
                "\n•Desayuno 1\n" +
                        "   - Avena\n" +
                        "   - Un mix de frutos secos\n" +
                        "-Freas o plátanos\n\n" +
                        "•Desayuno 2\n"+
                        "   - Yogurt Natural\n" +
                        "   - Frutas Frescas\n" +
                        "   - 1 Cda de salvado de avena, semillas de linaza o chia\n\n"+
                        "•Desayuno 3\n"+
                        "   - Juego de frutas con 1 cdta de ajonjolí o semillas de linaza\n" +
                        "   - Una tortilla de verduras variadas\n\n" ,R.drawable.deficit,
                "Algo pesado", "SuperHábit Calórico",
                "\n•Desayuno 1\n" +
                        "   - Avena\n" +
                        "   - Un mix de frutos secos\n" +
                        "-Freas o plátanos\n\n" +
                        "•Desayuno 2\n"+
                        "   - Yogurt Natural\n" +
                        "   - Frutas Frescas\n" +
                        "   - 1 Cda de salvado de avena, semillas de linaza o chia\n\n"+
                        "•Desayuno 3\n"+
                        "   - Juego de frutas con 1 cdta de ajonjolí o semillas de linaza\n" +
                        "   - Una tortilla de verduras variadas\n\n", R.drawable.calorias));


    }
}
