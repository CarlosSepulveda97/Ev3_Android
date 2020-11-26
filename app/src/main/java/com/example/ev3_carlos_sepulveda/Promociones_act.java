package com.example.ev3_carlos_sepulveda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import Model.Promociones;

public class Promociones_act extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private Spinner spinner;
    private EditText ed1,ed2;
    private TextView tv1,tv2;

    private Promociones promocion;
    private Cliente selectedClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);
        getSupportActionBar().hide();
        iniciarFireBase();
        spinner = (Spinner) findViewById(R.id.spinner);
        ed1 = (EditText) findViewById(R.id.editTextTextPersonName5);
        ed2 = (EditText) findViewById(R.id.editTextTextPersonName6);
        tv1 = (TextView) findViewById(R.id.textView3);
        tv2 = (TextView) findViewById(R.id.textView4);

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnapshot : snapshot.getChildren()){
                    Cliente cliente = objSnapshot.getValue(Cliente.class);
                    listaClientes.add(cliente);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaClientes);
                    spinner.setAdapter(adapt);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (Cliente cliente : listaClientes){
                    if (spinner.getSelectedItem().toString().equalsIgnoreCase(cliente.getNombre())){
                        ed1.setText(cliente.getPromo());
                        selectedClient = cliente;
                        if(cliente.getPromo().equalsIgnoreCase("Pizzas promo")){
                            promocion = Promociones.PROMO;
                        }else if(cliente.getPromo().equalsIgnoreCase("Master pizza")){
                            promocion = Promociones.MASTER;
                        }else if(cliente.getPromo().equalsIgnoreCase("Pizza max")){
                            promocion = Promociones.MAX;
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void calcular(View v){
        int suma = promocion.getCosto() + Integer.parseInt(ed2.getText().toString());

        tv1.setText("Estimado(a) " + selectedClient.getNombre() + " el coso final es: ");
        tv2.setText(suma + "");
    }



    public void iniciarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

}