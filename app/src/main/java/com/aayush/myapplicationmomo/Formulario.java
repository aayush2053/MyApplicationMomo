package com.aayush.myapplicationmomo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Formulario extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        this.setTitle("Form");

        Button idDone = findViewById(R.id.idDone);
        Button idCancel = findViewById(R.id.idCancel);
        idDone.setOnClickListener(this);
        idCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCancel:
                onBackPressed();
                break;

        }
    }

}



