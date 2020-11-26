package com.example.ev3_carlos_sepulveda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Model.Cliente;

public class ListadoClientes_act extends AppCompatActivity {

    private ListView list;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private Cliente selectedClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);
        getSupportActionBar().hide();

        list = (ListView) findViewById(R.id.list);

        iniciarFireBase();

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnapshot : snapshot.getChildren()){
                    Cliente cliente = objSnapshot.getValue(Cliente.class);
                    listaClientes.add(cliente);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaClientes);
                    list.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                selectedClient = (Cliente) adapterView.getItemAtPosition(i);

            }
        });

    }

    public void eliminar (View v){

        Cliente cliente = new Cliente();
        cliente.setId(selectedClient.getId());
        databaseReference.child("Clientes").child(cliente.getId()).removeValue();
        Toast.makeText(this, "Se ha eliminado a" + selectedClient.getNombre(), Toast.LENGTH_SHORT).show();

    }



    public void iniciarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}