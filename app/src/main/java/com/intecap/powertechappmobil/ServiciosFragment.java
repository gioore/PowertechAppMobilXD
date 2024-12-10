package com.intecap.powertechappmobil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class ServiciosFragment extends Fragment {


    private int selectedPrice = -1;

    public ServiciosFragment() {

    }

    public static ServiciosFragment newInstance() {
        return new ServiciosFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_servicios, container, false);


        TextView txtList = view.findViewById(R.id.txt_list);
        LinearLayout itemTop = view.findViewById(R.id.item_top);
        LinearLayout itemLeft = view.findViewById(R.id.item_left);
        LinearLayout itemRight = view.findViewById(R.id.item_right);
        Button btnConfirm = view.findViewById(R.id.btn_confirm);


        itemTop.setOnClickListener(v -> {
            selectedPrice = 300; // Precio fijo del ítem superior
            txtList.setText("Seleccionaste: Item 1 - Precio: $300");
        });


        itemLeft.setOnClickListener(v -> {
            selectedPrice = 50; // Precio fijo del ítem izquierdo
            txtList.setText("Seleccionaste: Item 2 - Precio: $50");
        });


        itemRight.setOnClickListener(v -> {
            selectedPrice = 1000; // Precio indefinido ahora vale 1000
            txtList.setText("Seleccionaste: Item 3 - Precio: $1000");
        });


        btnConfirm.setOnClickListener(v -> {
            if (selectedPrice == -1) {
                Toast.makeText(getActivity(), "Por favor selecciona un ítem.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Confirmado. Total: $" + selectedPrice, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}