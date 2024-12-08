package com.intecap.powertechappmobil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder> {

    private List<ModeloProducto> productos;
    private Context context;

    // Constructor
    public ProductosAdapter(Context context, List<ModeloProducto> productos) {
        this.context = context;
        this.productos = productos != null ? productos : new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModeloProducto producto = productos.get(position);

        // Configurar datos
        holder.txtNombre.setText(producto.getNombreProducto());
        holder.txtPrecio.setText(String.valueOf(producto.getPrecioProducto()));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.lblCardNombre);
            txtPrecio = itemView.findViewById(R.id.lblCardPrecio);
        }
    }
}
