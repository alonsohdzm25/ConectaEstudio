package com.conectaestudio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.conectaestudio.databinding.ActivityInscripcionesBinding;

public class InscripcionesActivity extends AppCompatActivity {

    private ActivityInscripcionesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInscripcionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}
