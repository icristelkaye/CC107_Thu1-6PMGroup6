package com.example.tcuappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AccountingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounting);
    }

    public void btn_backC(View view) {
        startActivity(new Intent(getApplicationContext(),TcuOffices.class));
    }

    public void btn_setC(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
    }
}