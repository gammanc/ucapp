package com.team.ucapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team.ucapp.R;
import com.team.ucapp.utils.MessageDeserializer;

public class LoginActivity extends AppCompatActivity {

    EditText txtUser, txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    void checkLogin(){

        //Obteniendo las referencias del heap
        txtUser = findViewById(R.id.txt_user);
        txtPassword = findViewById(R.id.txt_psswd);
        btnLogin = findViewById(R.id.btn_login);

        //Definimos la acción
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v){
                final String user = txtUser.getText().toString();
                final String pass = txtPassword.getText().toString();

                //Haciendo validaciones para evitar cadenas vacías
                if(user.trim().length() == 0) txtUser.setError("User is required");
                if(pass.trim().length() == 0) txtPassword.setError("Password is required");

                //Si los datos son válidos
                if(user.trim().length() > 0 && pass.trim().length() > 0){

                    Gson gson = new GsonBuilder().registerTypeAdapter(
                            String.class,
                            new MessageDeserializer()
                    ).create();

                    //Pendiente


                }

            }
        });
    }
}
