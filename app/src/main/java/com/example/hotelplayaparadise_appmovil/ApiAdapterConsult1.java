package com.example.hotelplayaparadise_appmovil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adaptador para RecyclerView en Java
public class ApiAdapterConsult1 extends RecyclerView.Adapter<ApiAdapterConsult1.ApiViewHolder> {

    private final List<ApiConsulta1> dataList;

    // Constructor del adaptador, recibe la lista de datos
    public ApiAdapterConsult1(List<ApiConsulta1> dataList) {
        this.dataList = dataList;
    }

    // Clase interna que representa el ViewHolder, que contiene las vistas de cada ítem
    public static class ApiViewHolder extends RecyclerView.ViewHolder {
        TextView TipoHabitacion;
        TextView Temporada;
        TextView NombreCliente;
        TextView DiasOcupacion;

        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);
            TipoHabitacion = itemView.findViewById(R.id.text_TipoHabitacion);
            Temporada = itemView.findViewById(R.id.textTemporada);
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
        ApiConsulta1 currentItem = dataList.get(position);

        holder.TipoHabitacion.setText("Tipo de Habitación: " + currentItem.getTipoHabitacion());
        holder.Temporada.setText("Temporada: " + currentItem.getTemporada());
        holder.NombreCliente.setText("Nombre del Cliente: " + currentItem.getNombreClientes());
        holder.DiasOcupacion.setText("Días de Ocupación: " + currentItem.getDiasOcupacion());

    }

    // Devuelve el tamaño de tu dataset (invocado por el layout manager)
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

