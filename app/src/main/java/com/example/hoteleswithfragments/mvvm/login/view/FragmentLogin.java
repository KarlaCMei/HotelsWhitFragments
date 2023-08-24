package com.example.hoteleswithfragments.mvvm.login.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hoteleswithfragments.mvvm.login.viewModel.LoginViewModel;
import com.example.hoteleswithfragments.utils.CustomSharedPreferences;
import com.example.hoteleswithfragments.mvvm.home.HomeActivity;
import com.example.hoteleswithfragments.R;
import com.example.hoteleswithfragments.databinding.FragmentLoginBinding;

import java.util.regex.Pattern;

public class FragmentLogin extends Fragment {
    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

    public FragmentLogin() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        observer();
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((binding.editTextEmail.getText() == null || binding.editTextEmail.getText().toString().equals("") || !validarEmail(binding.editTextEmail.getText().toString().trim()))) {
                    binding.editTextEmail.setError("Email no valido");
                    Toast.makeText(requireContext(), getString(R.string.mensaje_ingresar), Toast.LENGTH_LONG).show();
                } else if ((binding.editTextPassword.getText() == null || binding.editTextPassword.getText().toString().equals("") || binding.editTextPassword.getText().toString().length() < 6)) {
                    binding.editTextPassword.setError("La contraseña tiene que ser mayor a 6 digitos");
                    Toast.makeText(requireContext(), getString(R.string.mensaje_ingresar), Toast.LENGTH_LONG).show();
                } else {
                    isLogin();
                }

            }
        });

        binding.editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (validateEmail(charSequence)) {
                    if (validatePassword(binding.editTextPassword.getText().toString())) {
                        binding.btnLogin.setEnabled(true);
                        binding.editTextPassword.setError(null);
                    } else {
                        binding.editTextPassword.setError("La contraseña tiene que ser mayor a 6 digitos");
                    }
                    binding.editTextEmail.setError(null);
                } else {
                    binding.btnLogin.setEnabled(false);
                    binding.editTextEmail.setError("Email no valido");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        binding.editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (validatePassword(charSequence)) {
                    if (validateEmail(binding.editTextEmail.getText().toString())) {
                        binding.btnLogin.setEnabled(true);
                        binding.editTextEmail.setError(null);
                    } else {
                        binding.editTextEmail.setError("Email no valido");
                    }
                    binding.editTextPassword.setError(null);
                } else {
                    binding.btnLogin.setEnabled(false);
                    binding.editTextPassword.setError("La contraseña tiene que ser mayor a 6 digitos");

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private boolean validateEmail(CharSequence text) {
        return text != null && !text.toString().equals("") && validarEmail(text.toString().trim());
    }

    private boolean validatePassword(CharSequence text) {
        return (text != null && !text.toString().equals("") && text.toString().length() > 6);
    }


    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }


    @Override
    public void onResume() {
        super.onResume();
        checkSession();
    }

    public void checkSession() {
        boolean isLogin = CustomSharedPreferences.getSharedBoolean("IS_LOGIN_SHARED_KEY");
        if (isLogin) {
            startActivity(new Intent(requireContext(), HomeActivity.class));
            requireActivity().finish();
        }
    }

    public void isLogin(){
        viewModel.isLogin(binding.editTextEmail.getText().toString(), binding.editTextPassword.getText().toString());
    }

    private void observer(){
        viewModel.getUser().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    CustomSharedPreferences.setSharedBoolean("IS_LOGIN_SHARED_KEY", true);
                    Intent intent = new Intent(requireActivity(), HomeActivity.class);
                    startActivity(intent);
                    requireActivity().finish();
                }else{
                    Toast.makeText(binding.editTextEmail.getContext(), "Usuario no valido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}