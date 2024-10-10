package com.example.hotelplayaparadise_appmovil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adaptador para RecyclerView en Java
public class ApiAdapterConsult2 extends RecyclerView.Adapter<ApiAdapterConsult2.ApiViewHolder> {

    private final List<Apiconsulta2> datalist2;

    // Constructor del adaptador, recibe la lista de datos
    public ApiAdapterConsult2(List<Apiconsulta2> dataList) {
        this.datalist2 = dataList;
    }

    // Clase interna que representa el ViewHolder, que contiene las vistas de cada ítem
    public static class ApiViewHolder extends RecyclerView.ViewHolder {

        TextView NombreCliente;
        TextView DiasOcupacion;

        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);

            NombreCliente = itemView.findViewById(R.id.textNombre_Cliente);
            DiasOcupacion = itemView.findViewById(R.id.textDias_ocupacion);
        }
    }

    // Crea nuevas vistas (invocada por el layout manager)
    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout del ítem
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview_consult1, parent, false);
        return new ApiViewHolder(itemView);
    }

    // Reemplaza el contenido de una vista (invocada por el layout manager)
    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
        // Obtener el elemento de la lista en la posición actual y reemplazar el contenido de la vista
        Apiconsulta2 currentItem = datalist2.get(position);

        holder.NombreCliente.setText("Nombre del Cliente: " + currentItem.getNombreClientes());
        holder.DiasOcupacion.setText("Días de Ocupación: " + currentItem.getDiasOcupacion());

    }

    // Devuelve el tamaño de tu dataset (invocado por el layout manager)
    @Override
    public int getItemCount() {
        return datalist2.size();
    }
}

