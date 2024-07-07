package com.example.trytry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Signup extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    Button datePickerButton;
    EditText dateInputText;
    Button btnsubmit;
    DBHelper dbHelper;
    TextInputEditText fname,surname,username,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnsubmit=findViewById(R.id.submitButton);
        fname=findViewById(R.id.fnameText);
        surname=findViewById(R.id.surnameText);
        email=findViewById(R.id.emailText);
        username=findViewById(R.id.usernameText);
        password=findViewById(R.id.passwordText);

        dateInputText = findViewById(R.id.dateInputText);
        datePickerButton = findViewById(R.id.datePickerButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.trytry.DatePicker mDatePickerDialogFragment;
                mDatePickerDialogFragment = new com.example.trytry.DatePicker();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");


            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=fname.getText().toString();
                String surname1=surname.getText().toString();
                String username1=username.getText().toString();
                String email1=email.getText().toString();
                String password1=password.getText().toString();
                dbHelper = new DBHelper(view.getContext());
                boolean b =dbHelper.insertUserData(name1,surname1,username1,email1,password1);
                if (name1.isEmpty()||surname1.isEmpty()||username1.isEmpty()||email1.isEmpty()||password1.isEmpty()){
                    Toast.makeText(Signup.this,"Please fill up all fields",Toast.LENGTH_SHORT).show();
                }
                else if (b){
                    Toast.makeText(Signup.this,"Data inserted",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Signup.this,Login.class);
                    startActivity(i);
                }else {
                    Toast.makeText(Signup.this,"Failed To insert Data",Toast.LENGTH_SHORT).show();
                }
            }
        });

            }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();

        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        dateInputText.setText(selectedDate);





    }

    }
