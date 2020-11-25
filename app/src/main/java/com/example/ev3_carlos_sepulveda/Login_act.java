package com.example.ev3_carlos_sepulveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_act extends AppCompatActivity {

    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_act);
        getSupportActionBar().hide();

        et1 = (EditText) findViewById(R.id.editTextTextPersonName);
        et2 = (EditText) findViewById(R.id.editTextTextPassword);
    }

    public void login(View v){

        if (et1.getText().toString().equalsIgnoreCase("android") &&
            et2.getText().toString().equalsIgnoreCase("123")){

            Intent intent = new Intent(this,Menu_act.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
        }


    }






}