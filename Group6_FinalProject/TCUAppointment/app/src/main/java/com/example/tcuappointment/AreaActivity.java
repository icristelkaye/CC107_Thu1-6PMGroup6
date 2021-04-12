package com.example.tcuappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
    }

    public void btn_backG(View view) {
        startActivity(new Intent(getApplicationContext(),TcuOffices.class));
    }

    public void btn_setG(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
    }
}