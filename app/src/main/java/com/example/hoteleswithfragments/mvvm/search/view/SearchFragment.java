package com.example.hoteleswithfragments.mvvm.search.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hoteleswithfragments.BuildConfig;
import com.example.hoteleswithfragments.utils.Constants;
import com.example.hoteleswithfragments.format_epoch.DatePickerFragment;
import com.example.hoteleswithfragments.format_epoch.OnSelectTime;
import com.example.hoteleswithfragments.R;
import com.example.hoteleswithfragments.format_epoch.TimePickerFragment;
import com.example.hoteleswithfragments.databinding.FragmentSearchBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class SearchFragment extends Fragment {
    private FusedLocationProviderClient fusedLocationClient;


    private ActivityResultLauncher<String[]> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {

                Boolean findLocationGranted = result.getOrDefault(android.Manifest.permission.ACCESS_FINE_LOCATION, false);
                Boolean coarseLocationGranted = result.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false);


                /**
                 * Decirle al usuario de manera elegante que la app no va a funcionar de manera optima
                 * si no acepta los permisos
                 */
                if ((findLocationGranted != null && findLocationGranted) && (coarseLocationGranted != null && coarseLocationGranted)) {

                    Log.e("mensaje", "PERMISO OTORGADO");
                    getLocation();

                } else {
                    Log.e("mensaje", "PERMISO DENEGADO");
                }
            });


    private Long fecha;
    private Long hora;
    private FragmentSearchBinding binding;
    SimpleDateFormat formatHour = new SimpleDateFormat("h:mm a", Locale.getDefault());
    SimpleDateFormat formatDate = new SimpleDateFormat("EEE, MMM d, ''yy", Locale.getDefault());

    public SearchFragment() {
    }

    public static SearchFragment newInstance(String param1, String param2) {
        return new SearchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext());


        configToolbar();

        binding.btnEpochDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        binding.btnEpochHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });

        binding.btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((binding.editTextNameDestination.getText() == null || binding.editTextNameDestination.getText().toString().equals("")) ||
                        (binding.editTextNumPeople.getText() == null || binding.editTextNumPeople.getText().toString().equals(""))) {
                    Toast.makeText(requireContext(), getString(R.string.mensaje_ingresar), Toast.LENGTH_LONG).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.TITLE_SEARCH_DESTINY, binding.editTextNameDestination.getText().toString());
                    bundle.putLong(Constants.TIME, hora);
                    bundle.putLong(Constants.DATE, fecha);
                    Navigation.findNavController(view).navigate(R.id.action_searchFragment_to_listaHotelesFragment, bundle);
                }
            }
        });

        /**
         * Agragar la accion que va a llevar el icono de location
         */

        binding.icLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermissions();
            }
        });


    }

    private void configToolbar() {
        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.toolbar.toolbarSearch);
        if (((AppCompatActivity) requireActivity()).getSupportActionBar() != null) {
            if (getArguments().containsKey(Constants.TITLE_SEARCH_ACTIVITY)) {
                if (((AppCompatActivity) requireActivity()).getSupportActionBar() != null) {
                    ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(getArguments().getString(Constants.TITLE_SEARCH_ACTIVITY, " "));

                    //getSupportActionBar().setTitle(getArguments().containsKey(Constants.TITLE_SEARCH_ACTIVITY));
                }
            }
        }
    }


    public void showTimePickerDialog() {
        DialogFragment newFragment = new TimePickerFragment(new OnSelectTime() {
            @Override
            public void timeSelect(Long timeSelected) {
                String showHour = formatHour.format(timeSelected);
                binding.btnEpochHour.setText(showHour);
                hora = timeSelected;
            }
        });
        newFragment.show(getChildFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment(new OnSelectTime() {
            @Override
            public void timeSelect(Long dateSelected) {
                String showFecha = formatDate.format(dateSelected);
                binding.btnEpochDate.setText(showFecha);
                fecha = dateSelected;
            }
        });
        newFragment.show(getChildFragmentManager(), "datePicker");
    }


    /**
     * metodo para agragar la acion de permisos
     */

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(
                requireContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            /**
             * Paso 4: verificar si el usuario ya otorgo el permiso
             */
            Log.e("mensaje", "PERMISO ACEPTADO");
            getLocation();


        } else if (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_COARSE_LOCATION) && shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            /**
             * paso 5: En caso de ya haber mostrsado el mensaje del sistema, le mostraremos un mendaje
             * customisado del porque deberia aceptar el permiso
             */

            Snackbar mySnackbar = Snackbar.make(binding.search,
                    "Habilitar la ubicacion manualmente ", Snackbar.LENGTH_SHORT);
            mySnackbar.setAction("SETTINGS", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + BuildConfig.APPLICATION_ID)));
                }
            });
            mySnackbar.show();

            Log.e("mensaje", "SE REQUIERE USAR EL PERMISO PARA ACCEDER A LA UBICACION");
        } else {

            /**
             * Paso 6: Mostrar el mensaje de permisos del sistemo
             */
            Log.e("mensaje", "MENSAJE DEL SISTEMA");
            requestPermissionLauncher.launch(new String[]{
                    android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION
            });

        }
    }


    @SuppressLint("MissingPermission")
    private void getLocation() {
        fusedLocationClient.getLastLocation().addOnSuccessListener(requireActivity(),new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {

                    binding.editTextNameDestination.setText(("" + location.getLatitude()+ " " + location.getLongitude()));
                    //Log.e("mensaje", "Ubicacion " + location.getLatitude() + location.getLongitude());
                }
            }

        });
    }

}