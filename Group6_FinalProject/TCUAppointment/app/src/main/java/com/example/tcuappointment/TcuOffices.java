package com.example.tcuappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TcuOffices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcu_offices);
    }

    public void btn_Registrar(View view) {
        startActivity(new Intent(getApplicationContext(),RegistrarActivity.class));
    }

    public void btn_Osas(View view) {
        startActivity(new Intent(getApplicationContext(),OsasActivity.class));
    }

    public void btn_Accounting(View view) {
        startActivity(new Intent(getApplicationContext(),AccountingActivity.class));
    }

    public void btn_Alumni(View view) {
        startActivity(new Intent(getApplicationContext(),AlumniActivity.class));
    }

    public void btn_Dean(View view) {
        startActivity(new Intent(getApplicationContext(),DeanActivity.class));
    }

    public void btn_Vp(View view) {
        startActivity(new Intent(getApplicationContext(),VpActivity.class));
    }

    public void btn_Area(View view) {
        startActivity(new Intent(getApplicationContext(),AreaActivity.class));
    }

    public void btn_Library(View view) {
        startActivity(new Intent(getApplicationContext(),LibraryActivity.class));
    }
}