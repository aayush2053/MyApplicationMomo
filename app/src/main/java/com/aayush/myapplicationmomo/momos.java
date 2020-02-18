package com.aayush.myapplicationmomo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class momos extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momos);

        this.setTitle("Tipos de Momo");

        Button btAdd = findViewById(R.id.idAdd);
        Button btCancel = findViewById(R.id.idCancel);
        ImageView iv = findViewById(R.id.imageView2);

        btAdd.setOnClickListener(this);
        btCancel.setOnClickListener(this);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("idNombre");
        String descripcion = intent.getStringExtra("idDescripcion");
        String momoClase = intent.getStringExtra("foto");
        if(momoClase.equals("steam")){
            iv.setImageResource(R.drawable.steam);
        }
        else{
            iv.setImageResource(R.drawable.fried);
        }
        TextView tvNombre = findViewById(R.id.idNombre);
        TextView tvDescripcion = findViewById(R.id.idDescrpcion);
        tvNombre.setText(nombre);
        tvDescripcion.setText(descripcion);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.idAdd:
                Intent intent = new Intent(this,SelectedList.class);
                TextView idNombre = findViewById(R.id.idNombre);
                String nombre = idNombre.getText().toString();
                Momo momo = new Momo(nombre);
                SelectedList.momo.add(momo);

                onBackPressed();
                startActivity(intent);


                break;

            case R.id.idCancel:
                onBackPressed();


                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favourite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itFavourite:
                Intent intent = new Intent(this, Favourite.class);
                TextView idNombre = findViewById(R.id.idNombre);
                String nombre = idNombre.getText().toString();
                Momo momo = new Momo(nombre);
                Favourite.momo.add(momo);

                onBackPressed();
                startActivity(intent);

                break;

        }
        return true;
    }



}
