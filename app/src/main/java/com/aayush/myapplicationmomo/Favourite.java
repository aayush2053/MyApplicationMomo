package com.aayush.myapplicationmomo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Favourite extends AppCompatActivity implements View.OnClickListener {
    public static ArrayList<Momo> momo= new ArrayList<>();
    public static ArrayAdapter<Momo> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        this.setTitle("My Favourite List");
        Button btCancel = findViewById(R.id.idCancel);
        btCancel.setOnClickListener(this);

        Button btClear = findViewById(R.id.idClear);
        btClear.setOnClickListener(this);


        ListView idFavourite= findViewById(R.id.idFavourite);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, momo);
        idFavourite.setAdapter(adaptador);

        registerForContextMenu(idFavourite);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCancel:
               onBackPressed();
                break;

            case R.id.idClear:
                momo.clear();
                adaptador.notifyDataSetChanged();

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
