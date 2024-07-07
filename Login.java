package com.example.trytry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    Button signup, login;
    TextInputEditText username, password;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean e = false, p = false;
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.textusername);
        password = findViewById(R.id.passwordTextlgin);
        login = findViewById(R.id.btnlogin);
        signup = findViewById(R.id.btnsup);
        dbHelper = new DBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameCheck = username.getText().toString();
                String passCheck = password.getText().toString();
                Cursor cursor = dbHelper.getData();
                if (cursor.getCount() == 0) {
                    Toast.makeText(Login.this, "No entries Exists", Toast.LENGTH_LONG).show();
                }

                if (loginCheck(cursor, usernameCheck, passCheck)) {
                    Intent intent = new Intent(Login.this, FinalPage.class);
                    intent.putExtra("username", usernameCheck);
                    intent.putExtra("password",passCheck);
                    username.setText("");
                    password.setText("");
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setCancelable(true);
                    builder.setTitle("Wrong Credential");
                    builder.setMessage("Wrong Credential");
                    builder.show();
                }
                dbHelper.close();

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignupactivity();


            }
        });
    }

    public void opensignupactivity() {
        Intent signupintent = new Intent(getApplicationContext(), Signup.class);
        startActivity(signupintent);
        this.finish();
    }

    public boolean loginCheck(Cursor cursor,String usernamecheck,String passcheck) {
        while (cursor.moveToNext()) {
            if (cursor.getString(0).equals(usernamecheck)) {
                if (cursor.getString(0).equals(passcheck))
                    return true;
            }
            return false;
        }
        return false;
    }
            }
