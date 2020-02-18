package com.aayush.myapplicationmomo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectedList extends AppCompatActivity implements View.OnClickListener {
    public static ArrayList<Momo>momo= new ArrayList<>();
    public static ArrayAdapter<Momo> adaptador;
    float priceTotal=0, numMomo=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_list);
        this.setTitle("My Cart");

        Button btCancel = findViewById(R.id.idCancel);
        btCancel.setOnClickListener(this);

        Button btBuy = findViewById(R.id.idBuy);
        btBuy.setOnClickListener(this);

        ListView idSelected = findViewById(R.id.idSelected);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, momo);
        idSelected.setAdapter(adaptador);

        registerForContextMenu(idSelected);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCancel:
                onBackPressed();
                break;

            case R.id.idBuy:
                Intent intent = new Intent(this, Formulario.class);
                startActivity(intent);
                break;


        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextual,menu);
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int posicion = menuInfo.position;

        switch (item.getItemId()) {
            case R.id.idDelete:
                Momo momoDeleted = momo.remove(posicion);
                momo.remove(momoDeleted);
                Toast.makeText(this, "Item Deleted", Toast.LENGTH_SHORT).show();
                adaptador.notifyDataSetChanged();
                onResume();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}