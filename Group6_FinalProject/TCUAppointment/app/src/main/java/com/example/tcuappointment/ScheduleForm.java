package com.example.tcuappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class ScheduleForm extends AppCompatActivity {

    EditText date,appointmentdate,appointmenttime,schedule;
    Button insertdata;
    ProgressDialog mProgressDialog;
    private static final String INSERTDATA_URL = "https://projtechmysql.000webhostapp.com/tcuform/add_schedule.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_form);

        date = (EditText)findViewById(R.id.editTextdate);
        appointmentdate = (EditText)findViewById(R.id.editTextappointdate);
        appointmenttime = (EditText)findViewById(R.id.editTextappointtime);
        schedule = (EditText)findViewById(R.id.editTextschedule);

        insertdata = (Button)findViewById(R.id.buttoninsertschedule);

        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date = date.getText().toString().trim().toLowerCase();
                String AppointmentDate = appointmentdate.getText().toString().trim().toLowerCase();
                String AppointmentTime = appointmenttime.getText().toString().trim().toLowerCase();
                String Schedule = schedule.getText().toString().trim().toLowerCase();

                if (Date.equals("")||AppointmentDate.equals("")||AppointmentTime.equals("")||Schedule.equals("")){
                    Toast.makeText(ScheduleForm.this, "Please Enter Details", Toast.LENGTH_SHORT).show();
                }
                InsertData();
            }
        });
    }

    private void InsertData() {

        String Date = date.getText().toString().trim().toLowerCase();
        String AppointmentDate = appointmentdate.getText().toString().trim().toLowerCase();
        String AppointmentTime = appointmenttime.getText().toString().trim().toLowerCase();
        String Schedule = schedule.getText().toString().trim().toLowerCase();

        if (Date.equals("")||AppointmentDate.equals("")||AppointmentTime.equals("")||Schedule.equals("")){
            Toast.makeText(ScheduleForm.this, "Please Enter Details", Toast.LENGTH_SHORT).show();
        }
        else {


            register(Date, AppointmentDate, AppointmentTime, Schedule);
        }
    }

    private void register(String Date, String AppointmentDate, String AppointmentTime, String Schedule) {
        class RegisterUsers extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgressDialog = new ProgressDialog(ScheduleForm.this);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setMessage("Please Wait....");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setCancelable(false);
                mProgressDialog.setProgress(0);
                mProgressDialog.setProgressNumberFormat(null);
                mProgressDialog.setProgressPercentFormat(null);
                mProgressDialog.show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                mProgressDialog.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ScheduleForm.this,LastActivity.class);
                startActivity(intent);
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();


                data.put("Date",params[0]);
                data.put("AppointmentDate", params[1]);
                data.put("AppointmentTime", params[2]);
                data.put("Schedule", params[3]);


                String result = ruc.sendPostRequest(INSERTDATA_URL, data);

                return result;
            }
        }

        RegisterUsers ru = new RegisterUsers();
        ru.execute(Date, AppointmentDate, AppointmentTime, Schedule);


    }
}