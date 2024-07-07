package com.example.trytry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalPage extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        text = findViewById(R.id.changeText);
        Intent intent = getIntent();
        String s2 = intent.getStringExtra("email");
        text.setText(s2);
    }
}
