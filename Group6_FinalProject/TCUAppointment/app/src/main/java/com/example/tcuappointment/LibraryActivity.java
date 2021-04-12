package com.example.tcuappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
    }

    public void btn_backH(View view) {
        startActivity(new Intent(getApplicationContext(),TcuOffices.class));
    }

    public void btn_setH(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
    }
}