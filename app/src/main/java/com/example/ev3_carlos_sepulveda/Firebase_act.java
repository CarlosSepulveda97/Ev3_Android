package com.example.ev3_carlos_sepulveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

import Model.Cliente;
import Model.Pedido;
import Model.Promociones;

public class Firebase_act extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private EditText ed1,ed2,ed3;
    private Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        getSupportActionBar().hide();
        iniciarFireBase();

        ed1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        ed2 = (EditText) findViewById(R.id.editTextTextPersonName3);
        ed3 = (EditText) findViewById(R.id.editTextTextPersonName4);

        bt1 = (Button) findViewById(R.id.button2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cliente cliente;

                if (ed3.getText().toString().equalsIgnoreCase("pizzas promo")
                        && !ed2.getText().toString().equalsIgnoreCase("")
                        && !ed1.getText().toString().equalsIgnoreCase("")){

                    Promociones promocion = new Promociones("Pizzas promo", 5990);
                    Pedido pedido = new Pedido(promocion, ed2.getText().toString());
                    cliente = new Cliente(UUID.randomUUID().toString(),ed1.getText().toString(), pedido);
                    databaseReference.child("Clientes").child(cliente.getId()).child(cliente.getNombre()).child(pedido.getDestino()).setValue(promocion);
                    Toast.makeText(Firebase_act.this, "Guardado", Toast.LENGTH_SHORT).show();

                }else if (ed3.getText().toString().equalsIgnoreCase("master pizza")
                        && !ed2.getText().toString().equalsIgnoreCase("")
                        && !ed1.getText().toString().equalsIgnoreCase("")){

                    Promociones promocion = new Promociones("Master pizza", 12990);
                    Pedido pedido = new Pedido(promocion, ed2.getText().toString());
                    cliente = new Cliente(UUID.randomUUID().toString(),ed1.getText().toString(), pedido);
                    databaseReference.child("Clientes").child(cliente.getId()).child(cliente.getNombre()).child(pedido.getDestino()).setValue(promocion);
                    Toast.makeText(Firebase_act.this, "Guardado", Toast.LENGTH_SHORT).show();

                }else if (ed3.getText().toString().equalsIgnoreCase("pizza max")
                        && !ed2.getText().toString().equalsIgnoreCase("")
                        && !ed1.getText().toString().equalsIgnoreCase("")){

                    Promociones promocion = new Promociones("Pizza max", 18500);
                    Pedido pedido = new Pedido(promocion, ed2.getText().toString());
                    cliente = new Cliente(UUID.randomUUID().toString(),ed1.getText().toString(), pedido);
                    databaseReference.child("Clientes").child(cliente.getId()).child(cliente.getNombre()).child(pedido.getDestino()).setValue(promocion);
                    Toast.makeText(Firebase_act.this, "Guardado", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Firebase_act.this, "Ingrese los campos correctamente", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void iniciarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    public void listar(View v){
        Intent intent = new Intent(this,ListadoClientes_act.class);
        startActivity(intent);
    }

}