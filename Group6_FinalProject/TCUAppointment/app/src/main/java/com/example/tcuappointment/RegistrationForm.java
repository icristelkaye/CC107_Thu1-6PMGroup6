package com.example.tcuappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegistrationForm extends AppCompatActivity {

    Spinner sp;
    boolean invalid = false;
    String Colector="";
    TextView txtalertName;
    EditText UserName,UserEmail,UserContact,UserAppoint;
    Button SubmitSave,btnSchedule;
    RadioButton Malebtn,Femalbtn;
    CheckBox student,faculty,alumni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        sp = findViewById(R.id.SpAppointment);
        UserName = findViewById(R.id.userName);
        UserEmail = findViewById(R.id.userEmail);
        UserContact = findViewById(R.id.userContact);
        UserAppoint = findViewById(R.id.userAppoint);
        txtalertName = findViewById(R.id.userAlert);
        Malebtn = findViewById(R.id.Male);
        Femalbtn = findViewById(R.id.Female);
        student = findViewById(R.id.Student);
        faculty = findViewById(R.id.Faculty);
        alumni = findViewById(R.id.Alumni);
        btnSchedule = findViewById(R.id.btnSchedule);
        SubmitSave = findViewById(R.id.btnSubmit);
        SubmitSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = UserName.getText().toString();
                String email = UserEmail.getText().toString();
                String contact = UserContact.getText().toString();
                String appoint = UserAppoint.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(RegistrationForm.this, "Please input the details", Toast.LENGTH_SHORT).show();
                } else if (name.equals("Mj") || name.equals("Samarita")) {
                    invalid = true;
                    txtalertName.setText("Name Already exist");
                } else if (name.equals("Cristel") || name.equals("Isuga")) {
                    invalid = true;
                    txtalertName.setText("Name Already exist");
                } else if (name.equals("Estifani") || name.equals("Delfin")) {
                    invalid = true;
                    txtalertName.setText("Name Already exist");
                } else if (email.isEmpty()) {
                    Toast.makeText(RegistrationForm.this, "Please input the details", Toast.LENGTH_SHORT).show();
                } else if (contact.isEmpty()) {
                    Toast.makeText(RegistrationForm.this, "Please input the details", Toast.LENGTH_SHORT).show();
                } else if (appoint.isEmpty()) {
                    Toast.makeText(RegistrationForm.this, "Please input the details", Toast.LENGTH_SHORT).show();
                } else {

                    Colector += name + "\n";
                    Colector += email + "\n";
                    Colector += contact + "\n";
                    Colector += appoint + "\n";
                    if (student.isChecked()) {
                        Colector += "Student" + "\n";
                        if (faculty.isChecked()) {
                            Colector += "Faculty" + "\n";
                        }
                        if (alumni.isChecked()) {
                            Colector += "Alumni" + "\n";
                        }
                    }
                    Toast.makeText(RegistrationForm.this, "User Info \n:" + Colector, Toast.LENGTH_SHORT).show();
                }

            }
        });

        List<String> categoryAppointment = new ArrayList<>();
        categoryAppointment.add("Select Appointment");
        categoryAppointment.add("Library");
        categoryAppointment.add("OSAS");
        categoryAppointment.add("College Dean");
        categoryAppointment.add("VP for Administration");
        categoryAppointment.add("Accounting Office");
        categoryAppointment.add("Area 2(for accounting)");
        categoryAppointment.add("Alumni and Placement Office");
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoryAppointment);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if (parent.getItemAtPosition(position).equals("Select Appointment")) {
                    //Do Nothing

                } else {
                    String item = parent.getItemAtPosition(position).toString();
                    Colector += item + "\n";
                    Toast.makeText(RegistrationForm.this, "Selected Appointment: " + item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        }

    public void btn_add_schedule(View view) {
        startActivity(new Intent(getApplicationContext(),ScheduleForm.class));
    }
}