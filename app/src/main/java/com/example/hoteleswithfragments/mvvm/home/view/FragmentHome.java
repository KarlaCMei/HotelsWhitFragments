package com.example.hoteleswithfragments.mvvm.home.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoteleswithfragments.utils.Constants;
import com.example.hoteleswithfragments.utils.CustomSharedPreferences;
import com.example.hoteleswithfragments.mvvm.login.view.MainActivity;
import com.example.hoteleswithfragments.R;
import com.example.hoteleswithfragments.databinding.FragmentHomeBinding;

public class FragmentHome extends Fragment {
    private FragmentHomeBinding binding;
    public FragmentHome() {
        // Required empty public constructor
    }

    public static FragmentHome newInstance(String param1, String param2) {
        return new FragmentHome();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configToolbar();

        binding.btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomSharedPreferences.setSharedBoolean("IS_LOGIN_SHARED_KEY",false);
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
                requireActivity().finish();
            }
        });


        binding.buttonHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.TITLE_SEARCH_ACTIVITY, getString(R.string.search_title_hotel));
                Navigation.findNavController( view).navigate(R.id.action_fragmentHome_to_searchFragment,bundle);
                //Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_searchFragment);

            }
        });

        binding.buttonPaquete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.TITLE_SEARCH_ACTIVITY, getString(R.string.search_title_pakage));
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_searchFragment,bundle);

            }
        });

        binding.buttonVuelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.TITLE_SEARCH_ACTIVITY, getString(R.string.search_title_fly));
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_searchFragment,bundle);

            }
        });
    }

    private void configToolbar() {
        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.toolbarHome);
        if (((AppCompatActivity) requireActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(R.string.toolbar_home);
        }
    }
}