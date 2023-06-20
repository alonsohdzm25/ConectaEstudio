package com.conectaestudio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.conectaestudio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final int INTERVALO = 2000;
    private long tiempoPrimerClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEspecialidades.setOnClickListener(view -> {
            Intent intent = new Intent(this, EspecialidadesActivity.class);
            startActivity(intent);
        });

        binding.btnInscripciones.setOnClickListener(view -> {
            Intent intent = new Intent(this, InscripcionesActivity.class);
            startActivity(intent);
        });

        binding.btnEventos.setOnClickListener(view -> {
            Intent intent = new Intent(this, EventosActivity.class);
            startActivity(intent);
        });

        binding.btnConocenos.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConocenosActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(this, "Vuelve a presionar para salir", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();

    }
}