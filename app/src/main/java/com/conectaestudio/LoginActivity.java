package com.conectaestudio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.conectaestudio.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.btnIngresar.setOnClickListener(view -> {

            String email = binding.txtUser.getText().toString();
            String password = binding.txtPass.getText().toString();

            if(email.equals("") || password.equals("")) {
                Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show();
            } else {
              Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);
              if (checkCredentials == true) {
                  Toast.makeText(this, "Login Satisfactorio", Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(this, MainActivity.class);
                  startActivity(intent);
              } else {
                  Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
              }
            }
        });

        binding.LayoutRegistrarse.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);

        });


    }

}
