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
                                "-Fresa o plátano\n\n" +
                                "•Desayuno 2\n"+
                                "   - Yogurt Natural\n" +
                                "   - Frutas Frescas\n" +
                                "   - 1 Cda de salvado de avena, semillas de linaza o chia\n\n"+
                                "•Desayuno 3\n"+
                                "   - Juego de frutas con 1 cdta de ajonjolí o semillas de linaza\n" +
                                "   - Una tortilla de verduras variadas\n\n" ,R.drawable.deficit,
                "Algo pesado", "SuperHábit Calórico",
                "\n•Desayuno 1\n" +
                        "   - Cereal con leche de almendras\n" +
                        "   - Tortilla dulce de kiwi, fresas y pera\n" +
                        "-Kiwi fresco con crema de coco y base de granola\n\n" +
                        "•Desayuno 2\n"+
                        "   - Tostadas de aguacate\n" +
                        "   - Smoothie de bayas de goji\n" +
                        "   - Crumble de manzana con maíz\n\n"+
                        "•Desayuno 3\n"+
                        "   - Tortillas de avena con plátano\n" +
                        "   - Hot-cakes con sorbente de limón y frutos rojos\n\n", R.drawable.calorias));
//COMIDA
        versionsList.add(new VersionsDieta("Comida", "Algo Ligero", "Défictcalórico",
                "\n•Comida 1\n" +
                        "   - Berenjenas rellenas de queso panela\n" +
                        "   - Alcachofas al horno con pico de gallo\n" +
                        "-Arroz basmati salteado con heura y verduras al curry\n\n" +
                        "•Comida 2\n"+
                        "   - Tatali de Atún\n" +
                        "   - Bacalao con alubias y acelgas\n" +
                        "   - Crema de guisantes\n\n"+
                        "•Comida 3\n"+
                        "   - Tostada de salmón con guacamole\n" +
                        "   - Verduras con avena\n\n" ,R.drawable.deficit,
                "Algo pesado", "SuperHábit Calórico",
                "\n•Comida 1\n" +
                        "   - Aguacate relleno con ensalada de salmón\n" +
                        "   - Sopa de tomates y frutos rojos\n" +
                        "-Verduras hervidas\n\n" +
                        "•Comida 2\n"+
                        "   - Tarta de atún y aguacate\n" +
                        "   - Ensalada de verdura con corte chiffonade\n" +
                        "   - Espaguetis de calabaza a la cúrcuma\n\n"+
                        "•Comida 3\n"+
                        "   - Tomate con ventresca de atún\n" +
                        "   - Verduras salteadas con romero y tomillo\n\n", R.drawable.calorias));
        //CENA
        versionsList.add(new VersionsDieta("Cena", "Algo Ligero", "Défictcalórico",
                "\n•Cena 1\n" +
                        "   - Rollos de lechiga romana \n" +
                        "   - Té de manzanilla\n" +
                        "-Mezcla de zanahoria, cebolla y pimiento rojo\n\n" +
                        "•Cena 2\n"+
                        "   - Ensalada de frutas\n" +
                        "   - Yogur de soja natural\n" +
                        "   - Una pizca de zumo de limón con un copete de nata de coco\n\n"+
                        "•Cena 3\n"+
                        "   - Crema de chamiñones\n" +
                        "   - Paté de vegetales\n\n" ,R.drawable.deficit,
                "Algo pesado", "SuperHábit Calórico",
                "\nComida 1\n" +
                        "   - Risottos con setas\n" +
                        "   - Nueces y brócoli\n" +
                        "-Semillas de lino y chía\n\n" +
                        "•Comida 2\n"+
                        "   - Fajita de maíz con tofu y guácamole\n" +
                        "   - Té de frutos rojos \n" +
                        "   - Tomatillos, lombarda, kale y espinacas\n\n"+
                        "•Comida 3\n"+
                        "   - Pizza de harina integral\n" +
                        "   - Con calabacín, rodajas de tomate, corazones de alcachofa y champiñones", R.drawable.calorias));


    }
}
