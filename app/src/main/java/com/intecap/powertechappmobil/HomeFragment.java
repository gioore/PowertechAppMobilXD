package com.intecap.powertechappmobil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<ModeloProducto> listaProductos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listaProductos = new ArrayList<>();
        listaProductos.add(new ModeloProducto("1", "Apple MacBook Air M2", "Ligero y potente, ideal para trabajar.", 50, true, 1199.99));
        listaProductos.add(new ModeloProducto("2", "Microsoft Surface Laptop 5", "Perfecto para productividad y diseño.", 30, true, 1499.99));
        listaProductos.add(new ModeloProducto("3", "ASUS ZenBook 14", "Ultraligero con diseño elegante.", 20, true, 899.99));
        listaProductos.add(new ModeloProducto("4", "Samsung Galaxy Book Pro", "Portátil versátil con pantalla AMOLED.", 15, true, 999.99));
        listaProductos.add(new ModeloProducto("5", "Lenovo Yoga Slim 7", "Convertible con gran duración de batería.", 25, true, 799.99));
        listaProductos.add(new ModeloProducto("6", "Acer Swift 3", "Económico pero poderoso.", 40, true, 649.99));
        listaProductos.add(new ModeloProducto("7", "HP Envy x360", "Potencia convertible con estilo.", 10, true, 1049.99));
        listaProductos.add(new ModeloProducto("8", "Razer Blade 15", "La mejor opción para gamers.", 5, false, 2399.99));
        listaProductos.add(new ModeloProducto("9", "LG Gram 16", "Increíblemente ligero con pantalla grande.", 12, true, 1299.99));
    }

    private ProductosAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rcvProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ProductosAdapter(listaProductos);
        recyclerView.setAdapter(adapter);

        return view;
    }
}