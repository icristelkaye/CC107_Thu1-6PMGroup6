package com.example.tcuappointment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class ExitPage extends AppCompatActivity {

    TextView prog, progA, progAA, progB, progBB, progC, progCC, progD, progDD, progE, progEE;
    Animation bounce_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_page);

        prog = findViewById(R.id.prog);
        progA = findViewById(R.id.progA);
        progAA = findViewById(R.id.progAA);
        progB = findViewById(R.id.progB);
        progBB = findViewById(R.id.progBB);
        progC = findViewById(R.id.progC);
        progCC = findViewById(R.id.progCC);
        progD = findViewById(R.id.progD);
        progDD = findViewById(R.id.progDD);
        progE = findViewById(R.id.progE);
        progEE = findViewById(R.id.progEE);
        bounce_anim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);

        prog.startAnimation(bounce_anim);
        progA.startAnimation(bounce_anim);
        progAA.startAnimation(bounce_anim);
        progB.startAnimation(bounce_anim);
        progBB.startAnimation(bounce_anim);
        progC.startAnimation(bounce_anim);
        progCC.startAnimation(bounce_anim);
        progD.startAnimation(bounce_anim);
        progDD.startAnimation(bounce_anim);
        progE.startAnimation(bounce_anim);
        progEE.startAnimation(bounce_anim);
    }
}