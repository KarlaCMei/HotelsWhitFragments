package com.example.hoteleswithfragments.mvvm.detali_hotel.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hoteleswithfragments.databinding.FragmentDetailHotelBinding;
import com.example.hoteleswithfragments.mvvm.detali_hotel.viewmodel.DetailHotelViewModel;
import com.example.hoteleswithfragments.mvvm.login.viewModel.LoginViewModel;
import com.example.hoteleswithfragments.utils.Constants;
import com.example.hoteleswithfragments.adapters.Imagen;
import com.example.hoteleswithfragments.R;
import com.example.hoteleswithfragments.adapters.DemoCollectionPagerAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DetailHotelFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    DemoCollectionPagerAdapter demoCollectionPagerAdapter;
    ViewPager viewPager;
    SimpleDateFormat formatHour = new SimpleDateFormat("h:mm a", Locale.getDefault());
    SimpleDateFormat formatDate = new SimpleDateFormat("EEE, MMM d, ''yy", Locale.getDefault());
    private FragmentDetailHotelBinding binding;
    private  String  nameHotel;
    private DetailHotelViewModel viewModel;

    public DetailHotelFragment() {
        // Required empty public constructor
    }
    public static DetailHotelFragment newInstance() {
        return new DetailHotelFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_hotel, container, false);
        viewModel = new ViewModelProvider(this).get(DetailHotelViewModel.class);
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readExtra();
        observer();

       SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.showMsg();
            }
        });

        binding.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });


        if(getArguments()!= null && getArguments().containsKey(Constants.URL_IMG_DETAIL_HOTEL)){
            ArrayList<Imagen> urlImagen = (ArrayList<Imagen>) getArguments().getSerializable(Constants.URL_IMG_DETAIL_HOTEL);
            Log.e("tamaño","tam: "+urlImagen.size());
            demoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getChildFragmentManager(), urlImagen);
            viewPager = view.findViewById(R.id.pager);
            viewPager.setAdapter(demoCollectionPagerAdapter);
        }

    }


    private void readExtra() {

        if(getArguments()!= null && getArguments().containsKey(Constants.HOTEL_NAME)){
            nameHotel = getArguments().getString(Constants.HOTEL_NAME);
            binding.toolbarHotelDetail.setTitle(nameHotel);
            //configToolbar(nameHotel);
        }

        if(getArguments()!= null && getArguments().containsKey(Constants.DESCRIPTION)){
            binding.textDescription.setText((getArguments().getString(Constants.DESCRIPTION)));
        }

        if (getArguments()!= null && getArguments().containsKey(Constants.LOCATION)) {
            binding.textUbicacion.setText((getArguments().getString(Constants.LOCATION)));
        }

        if (getArguments()!= null && getArguments().containsKey(Constants.PRICE_WITH_DISCOUNT)) {
            binding.textPrecioConDescuento.setText((getArguments().getString(Constants.PRICE_WITH_DISCOUNT)));
        }

        if (getArguments()!= null && getArguments().containsKey(Constants.PRICE_WITHOUT_DISCOUNT)) {
            binding.textPrecioSinDescuento.setText((getArguments().getString(Constants.PRICE_WITHOUT_DISCOUNT)));
        }

        if (getArguments()!= null && getArguments().containsKey(Constants.QUALIFICATION)) {
            binding.textCalificacion.setText((getArguments().getString(Constants.QUALIFICATION)));
        }

        if (getArguments()!= null && getArguments().containsKey(Constants.TITLE_DESCRIPTION)) {
            binding.textDescription.setText((getArguments().getString(Constants.TITLE_DESCRIPTION)));
        }

        if (getArguments()!= null && getArguments().containsKey(Constants.TIME)) {
            String showHour = formatHour.format(getArguments().getLong(Constants.TIME));
            binding.textViewMostrarHora.setText(showHour);
        }

        if(getArguments()!= null && getArguments().containsKey(Constants.DATE)){
            String showFecha = formatDate.format(getArguments().getLong(Constants.DATE));
            binding.textViewMostrarFecha.setText(showFecha);
        }

    }



    public  void createDialog(String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireContext());
        alertDialog.setMessage(msg);
        alertDialog.setTitle("RESERVAR");

        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(requireContext(), "¡Gracias por su reserva!", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.create().show();

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void observer(){
        viewModel.getMsg().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(Constants.CREATE_DIALOG){
                    createDialog(s);
                }
            }
        });
    }
}