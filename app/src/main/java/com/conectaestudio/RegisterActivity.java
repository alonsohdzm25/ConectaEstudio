package com.conectaestudio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.conectaestudio.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.btnRegistrar.setOnClickListener(view -> {

            String nombre = binding.txtNombre.getText().toString();
            String email = binding.txtCorreo.getText().toString();
            String password = binding.txtPass.getText().toString();
            String comfirmpassword = binding.txtComfirmPass.getText().toString();

            if (email.equals("") || password.equals("") || comfirmpassword.equals("") || password.equals("")) {
                Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show();
            } else {
                if (comfirmpassword.equals(password)) {
                    Boolean checkUserEmail = databaseHelper.checkEmail(email);
                    if (checkUserEmail == false) {
                        Boolean insert = databaseHelper.insertData(nombre,email,password);
                        if (insert == true) {
                            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Registro Fallido", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "El correo ya esta registrado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.LayoutIngresar.setOnClickListener( view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

    }
}
