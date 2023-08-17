package com.example.hoteleswithfragments.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoteleswithfragments.R;
import com.example.hoteleswithfragments.data.Hotel;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class CustomHotelAdapter extends RecyclerView.Adapter<CustomHotelAdapter.ViewHolder> {
    private ArrayList<Hotel> mDataSet;
    private OnClicHotelListener listener;

    public CustomHotelAdapter(ArrayList<Hotel> dataSet, OnClicHotelListener listener) {
        mDataSet = dataSet;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_list_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        vh.setListener(this.listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hotel myHotel = mDataSet.get(position);
        holder.setHotel(myHotel);
        holder.getTextName().setText(myHotel.getNombre());
        holder.getTextCalificacion().setText(myHotel.getCalificacion());
        holder.getTextPrecioSinDescuento().setText(myHotel.getPrecioSinDescuento());
        holder.getTextPrecioConDescuento().setText(myHotel.getPrecioConDescuento());
        ImageView ivBasicImage =holder.getImgUrl();
        Picasso.with(ivBasicImage.getContext()).load(myHotel.getUrlImg()).into(ivBasicImage);
    }
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CardView cardView;
        private final TextView textName;
        private final TextView textCalificacion;
        private final TextView textPrecioSinDescuento;
        private final TextView textPrecioConDescuento;
        private final ImageView imgUrl;
        private Hotel hotel;
        private OnClicHotelListener listener;

        public ViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.cardview);
            textName = v.findViewById(R.id.text_name);
            textCalificacion = v.findViewById(R.id.text_calificacion);
            textPrecioSinDescuento = v.findViewById(R.id.text_precio_sin_descuento);
            textPrecioConDescuento = v.findViewById(R.id.text_precio_con_descuento);
            imgUrl = v.findViewById(R.id.img_hotel);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getListener().onHotelClicListener(getHotel(), v);
                }
            });
        }


        public TextView getTextName() {
            return textName;
        }

        public TextView getTextCalificacion() {
            return textCalificacion;
        }

        public TextView getTextPrecioSinDescuento() {
            return textPrecioSinDescuento;
        }

        public TextView getTextPrecioConDescuento() {
            return textPrecioConDescuento;
        }

        public ImageView getImgUrl() {
            return imgUrl;
        }

        public Hotel getHotel() {
            return hotel;
        }

        public void setHotel(Hotel hotel) {
            this.hotel = hotel;
        }

        public OnClicHotelListener getListener() {
            return listener;
        }

        public void setListener(OnClicHotelListener listener) {
            this.listener = listener;
        }

    }
}
