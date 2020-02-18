package com.aayush.myapplicationmomo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btIrSteam;
    Button btIrFried;
    ImageView imageView2;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("MoMo's");

        btIrSteam= findViewById(R.id.idSteam);
        btIrFried= findViewById(R.id.idFried);
        btIrSteam.setOnClickListener(this);
        btIrFried.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.idSteam:
                Intent intent = new Intent(this, momos.class);
                String nombre= btIrSteam.getText().toString();
                intent.putExtra("idNombre", nombre);
                String descripcion="Usually, the momos are steamed. These scrumptious juicy momos are filled with minced veggies or meat and are put in dumpling steamer.";
                intent.putExtra("idDescripcion",descripcion);
                intent.putExtra("foto","steam");
                startActivity(intent);

                break;

            case R.id.idFried:
                Intent intent2 = new Intent(this, momos.class);
                String nombre2 = btIrFried.getText().toString();
                intent2.putExtra("idNombre",nombre2);
                String descripcion2="These crunchy version of momos are made by deep frying the momo or frying after steaming the momo. Although, a bit oily, the taste will totally make you forget about your health-conscious thoughts.";
                intent2.putExtra("idDescripcion",descripcion2);
                intent2.putExtra("foto","fried");
                startActivity(intent2);


                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.idFavourite:
                Intent intent = new Intent(this, Favourite.class);
                startActivity(intent);

                break;
            case R.id.idCart:
                Intent intent2 = new Intent(this, SelectedList.class);
                startActivity(intent2);

            break;

        }
        return true;
    }



}
