package com.example.hoteleswithfragments.mvvm.lista_hoteles.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoteleswithfragments.mvvm.lista_hoteles.viewmodel.ListaHotelesViewModel;
import com.example.hoteleswithfragments.utils.Constants;
import com.example.hoteleswithfragments.R;
import com.example.hoteleswithfragments.adapters.CustomHotelAdapter;
import com.example.hoteleswithfragments.adapters.OnClicHotelListener;


import com.example.hoteleswithfragments.data.Hotel;
import com.example.hoteleswithfragments.data.HotelList;
import com.example.hoteleswithfragments.databinding.FragmentListaHotelesBinding;

import java.util.ArrayList;

public class ListaHotelesFragment extends Fragment implements OnClicHotelListener{
    private FragmentListaHotelesBinding binding;
    private CustomHotelAdapter adapter;
    private String destinationName;
    private Long fecha;
    private Long hora;

    private ListaHotelesViewModel viewModel;


    public ListaHotelesFragment() {
    }
    public static ListaHotelesFragment newInstance(String param1, String param2) {
        ListaHotelesFragment fragment = new ListaHotelesFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_hoteles, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configToolbar();
        configView();

        adapter = new CustomHotelAdapter(HotelList.getHotels(), this);
        binding.listHotels.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.listHotels.setAdapter(adapter);
        /*requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_home,menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.share:
                        //Toast.makeText(this, "Vamonos a : " + nombre, Toast.LENGTH_SHORT).show();
                        openIntentImplicitoWithParams();
                        return true;

                    case android.R.id.home:
                        onBackPressed();
                        return true;
                    default:
                        return ListaHotelesFragment.super.onContextItemSelected(menuItem);
                }
                return false;
           }
        });*/

        /*View includedLayout = view.findViewById(R.id.toolbar_list_hotel);
        ImageView insideTheIncludedLayout = (ImageView)includedLayout.findViewById(R.id.ic_share);

        insideTheIncludedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntentImplicitoWithParams();

            }
        });*/

        binding.toolbar.icShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIntentImplicitoWithParams();
            }
        });


    }

    private void configToolbar() {
        //((AppCompatActivity) requireActivity()).setSupportActionBar(binding.toolbar.toolbarListHotel);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.toolbar.toolbarListHotel);

        if (((AppCompatActivity) requireActivity()).getSupportActionBar() != null) {
            if (getArguments().containsKey(Constants.TITLE_SEARCH_DESTINY)) {
                destinationName = getArguments().getString(Constants.TITLE_SEARCH_DESTINY);
                ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(destinationName);
            }
        }

        if(getArguments()!= null && getArguments().containsKey(Constants.DATE)){
            fecha = getArguments().getLong(Constants.DATE);
        }
        if(getArguments()!= null && getArguments().containsKey(Constants.TIME)){
            hora = getArguments().getLong(Constants.TIME);
        }

        }


    @Override
    public void onHotelClicListener(Hotel hotel, View view) {
        Bundle detailActivity = new Bundle();
        detailActivity.putString(Constants.HOTEL_NAME, hotel.getNombre());
        detailActivity.putString(Constants.QUALIFICATION, hotel.getCalificacion());
        detailActivity.putString(Constants.LOCATION, hotel.getUbicacion());
        detailActivity.putString(Constants.DESCRIPTION, hotel.getDescripcion());
        detailActivity.putString(Constants.PRICE_WITH_DISCOUNT, hotel.getPrecioConDescuento());
        detailActivity.putString(Constants.PRICE_WITHOUT_DISCOUNT, hotel.getPrecioSinDescuento());
        detailActivity.putLong(Constants.TIME,hora );
        detailActivity.putLong(Constants.DATE,fecha );
        detailActivity.putSerializable(Constants.URL_IMG_DETAIL_HOTEL,hotel.getImages());
        //detailActivity.putString(Constants.URL_IMG, hotel.getUrlImg());
        detailActivity.putString(Constants.URL_IMG, hotel.getUrlImg());
        Navigation.findNavController( view).navigate(R.id.action_listaHotelesFragment_to_detailHotelFragment,detailActivity);
    }

    private void openIntentImplicitoWithParams() {
        Intent intentImplicito = new Intent();
        intentImplicito.setAction(Intent.ACTION_SEND);
        intentImplicito.putExtra(Intent.EXTRA_TEXT, "Vamonos a : " + destinationName);
        intentImplicito.setType("text/plain");
        startActivity(intentImplicito);
    }

    public void configView(){
        viewModel = new ViewModelProvider(this).get(ListaHotelesViewModel.class);
        viewModel.getBooks();

        final Observer<ArrayList<Hotel>> observer = new Observer<ArrayList<Hotel>>() {
            @Override
            public void onChanged(ArrayList<Hotel> hotels) {

                adapter = new CustomHotelAdapter( hotels,ListaHotelesFragment.this);
                binding.listHotels.setAdapter(adapter);
            }
        };

        viewModel.getResult().observe(getViewLifecycleOwner(), observer);
    }
}