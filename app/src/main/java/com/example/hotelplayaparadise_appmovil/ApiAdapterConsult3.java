package com.example.hotelplayaparadise_appmovil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApiAdapterConsult3 extends RecyclerView.Adapter<ApiAdapterConsult3.ApiViewHolder> {

    private final List<DatosHotel> datosHotelList;

    // Constructor del adaptador, recibe la lista de datos
    public ApiAdapterConsult3(List<DatosHotel> datosHotelList) {
        this.datosHotelList = datosHotelList;
    }

    // Clase interna que representa el ViewHolder, que contiene las vistas de cada ítem
    public static class ApiViewHolder extends RecyclerView.ViewHolder {
        TextView textTipoHabitacion;
        TextView textTemporada;
        TextView textNombreCliente;
        TextView textDiasOcupacion;
        TextView textTitle;

        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);
            textTipoHabitacion = itemView.findViewById(R.id.text_TipoHabitacion);
            textTemporada = itemView.findViewById(R.id.textTemporada);
            textNombreCliente = itemView.findViewById(R.id.textNombre_Cliente);
            textDiasOcupacion = itemView.findViewById(R.id.textDias_ocupacion);
            textTitle = itemView.findViewById(R.id.textTitle);
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
        DatosHotel currentItem = datosHotelList.get(position);

        holder.textTipoHabitacion.setText("Tipo de Habitación: " + currentItem.getTipo_habitacion());
        holder.textTemporada.setText("Temporada: " + currentItem.getTemporada());
        holder.textNombreCliente.setText("Nombre del Cliente: " + currentItem.getNombre_cliente());
        holder.textDiasOcupacion.setText("Días de Ocupación: " + currentItem.getDias_ocupacion());
        holder.textTitle.setText("Hotel Playa Paradise");
    }

    // Devuelve el tamaño de tu dataset (invocado por el layout manager)
    @Override
    public int getItemCount() {
        return datosHotelList.size();
    }
}
