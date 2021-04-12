package com.example.tcuappointment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class Add_Data_Activity extends AppCompatActivity {

    EditText name,email,address,position;
    Button insertdata;
    ProgressDialog mProgressDialog;
    private static final String INSERTDATA_URL = "https://projtechmysql.000webhostapp.com/tcuform/add_data.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data_);


        name = (EditText)findViewById(R.id.editTextname);
        email = (EditText)findViewById(R.id.editTextemail);
        address = (EditText)findViewById(R.id.editTextaddress);
        position = (EditText)findViewById(R.id.editTextposition);

        insertdata = (Button)findViewById(R.id.buttoninsertdata);

        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString().trim().toLowerCase();
                String Email = email.getText().toString().trim().toLowerCase();
                String Address = address.getText().toString().trim().toLowerCase();
                String Position = position.getText().toString().trim().toLowerCase();

                if (Name.equals("")||Email.equals("")||Address.equals("")||Position.equals("")){
                    Toast.makeText(Add_Data_Activity.this, "Please Enter Detail", Toast.LENGTH_SHORT).show();
                }
                InsertData();

            }
        });

    }
    private void InsertData() {

        String Name = name.getText().toString().trim().toLowerCase();
        String Email = email.getText().toString().trim().toLowerCase();
        String Address = address.getText().toString().trim().toLowerCase();
        String Position = position.getText().toString().trim().toLowerCase();

        if (Name.equals("")||Email.equals("")||Address.equals("")||Position.equals("")){
            Toast.makeText(Add_Data_Activity.this, "Please Enter Detail", Toast.LENGTH_SHORT).show();
        }
        else {


            register(Name, Email, Address, Position);
        }
    }

    private void register(String Name, String Email, String Address, String Position) {
        class RegisterUsers extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgressDialog = new ProgressDialog(Add_Data_Activity.this);
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
                Intent intent = new Intent(Add_Data_Activity.this,RegistrationForm.class);
                startActivity(intent);
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();


                data.put("Name",params[0]);
                data.put("Email", params[1]);
                data.put("Address", params[2]);
                data.put("Position", params[3]);


                String result = ruc.sendPostRequest(INSERTDATA_URL, data);

                return result;
            }
        }

        RegisterUsers ru = new RegisterUsers();
        ru.execute(Name, Email, Address, Position);
    }
}
