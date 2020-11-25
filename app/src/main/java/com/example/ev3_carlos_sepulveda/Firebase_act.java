package com.example.ev3_carlos_sepulveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Firebase_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        getSupportActionBar().hide();


    }



    public void listar(View v){
        Intent intent = new Intent(this,ListadoClientes_act.class);
        startActivity(intent);
    }

}