package com.conectaestudio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.conectaestudio.databinding.ActivityEspecialidadesBinding;

public class EspecialidadesActivity extends AppCompatActivity {

    private ActivityEspecialidadesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEspecialidadesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}
