package com.example.hotelplayaparadise_appmovil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApiAdapterConsult3 extends RecyclerView.Adapter<ApiAdapterConsult3.ApiViewHolder> {

    private final List<Apiconsulta3> datalist3;

    // Constructor del adaptador, recibe la lista de datos
    public ApiAdapterConsult3(List<Apiconsulta3> dataList) {
        this.datalist3 = dataList;
    }

    // Clase interna que representa el ViewHolder, que contiene las vistas de cada ítem
    public static class ApiViewHolder extends RecyclerView.ViewHolder {
        TextView textMetodoReservacion;
        TextView textNombreCliente;
        TextView txtNumMes;
        TextView txtPrecioNoche;
        TextView textPrecioPaquete;

        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);
            textMetodoReservacion = itemView.findViewById(R.id.textMetodoReservacion);
            textNombreCliente = itemView.findViewById(R.id.textNombre_Clientes3);
            txtNumMes = itemView.findViewById(R.id.textNumMes);
            txtPrecioNoche = itemView.findViewById(R.id.textPrecioNoche);
            textPrecioPaquete = itemView.findViewById(R.id.textPrecioPaquete);
        }
    }

    // Crea nuevas vistas (invocada por el layout manager)
    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout del ítem
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_list_consulta3, parent, false);
        return new ApiViewHolder(itemView);
    }

    // Reemplaza el contenido de una vista (invocada por el layout manager)
    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
        // Obtener el elemento de la lista en la posición actual y reemplazar el contenido de la vista
        Apiconsulta3 currentItem = datalist3.get(position);

        holder.textMetodoReservacion.setText("Tipo de Habitación: " + currentItem.getMetodoreservacion());
        holder.textNombreCliente.setText("Temporada: " + currentItem.getNombreClientes());
        holder.txtNumMes.setText("Nombre del Cliente: " + currentItem.getNummes());
        holder.txtPrecioNoche.setText("Días de Ocupación: " + currentItem.getPrecionoche());
        holder.textPrecioPaquete.setText("Días de Ocupación: " + currentItem.getPreciopaquete());
    }

    // Devuelve el tamaño de tu dataset (invocado por el layout manager)
    @Override
    public int getItemCount() {
        return datalist3.size();
    }
}
