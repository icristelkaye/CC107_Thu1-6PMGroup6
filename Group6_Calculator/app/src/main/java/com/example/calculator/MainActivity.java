package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView result;
    Button add,subtract,multiply,divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText)findViewById(R.id.num1);
        number2 = (EditText)findViewById(R.id.num2);

        result = (TextView)findViewById(R.id.result);

        add = (Button)findViewById(R.id.buttonAdd);
        subtract = (Button)findViewById(R.id.buttonSubtract);
        multiply = (Button)findViewById(R.id.buttonMultiply);
        divide = (Button)findViewById(R.id.buttonDivide);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number1.getText().length() != 0 && number2.getText().length() != 0) {

                    double n1 = Double.parseDouble(number1.getText().toString());
                    double n2 = Double.parseDouble(number2.getText().toString());

                    double res = n1 + n2;

                    result.setText(String.valueOf(res));
                }
                else {
                    Toast.makeText(view.getContext(),"Please! Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number1.getText().length() != 0 && number2.getText().length() != 0) {

                    double n1 = Double.parseDouble(number1.getText().toString());
                    double n2 = Double.parseDouble(number2.getText().toString());

                    double res = n1 - n2;

                    result.setText(String.valueOf(res));
                }
                else {
                    Toast.makeText(view.getContext(),"Please! Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number1.getText().length() != 0 && number2.getText().length() != 0) {

                    double n1 = Double.parseDouble(number1.getText().toString());
                    double n2 = Double.parseDouble(number2.getText().toString());

                    double res = n1 * n2;

                    result.setText(String.valueOf(res));
                }
                else {
                    Toast.makeText(view.getContext(),"Please! Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(number1.getText().length() != 0 && number2.getText().length() != 0) {

                    double n1 = Double.parseDouble(number1.getText().toString());
                    double n2 = Double.parseDouble(number2.getText().toString());

                    double res = n1 / n2;

                    result.setText(String.valueOf(res));
                }
                else {
                    Toast.makeText(view.getContext(),"Please! Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        }
}