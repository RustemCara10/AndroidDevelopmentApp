package com.example.trytry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView myRecyclerView;
    private final ArrayList<Product> myProducts = new ArrayList<>();
    ImageView imagebasket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagebasket = findViewById(R.id.imageView3);
        myRecyclerView = findViewById(R.id.myRecyclerView);
        Product p1 = new Product("Belvedere Vodka 70cl", 10, 34, R.drawable.belvedere);
        Product p2 = new Product("Grey Goose Vodka 70cl", 10, 37, R.drawable.greygoose);
        Product p3 = new Product("Kraken Spiced Rum", 10, 32, R.drawable.kraken);
        Product p4 = new Product("Mccallan 20yr", 10, 36, R.drawable.mccallan);

        myProducts.add(p1);
        myProducts.add(p2);
        myProducts.add(p3);
        myProducts.add(p4);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        MyAdapter listAdapter = new MyAdapter(myProducts, this);
        myRecyclerView.setAdapter(listAdapter);
        imagebasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openloginactivity();
                Toast.makeText(getApplicationContext(), "To continue you need to login or signup!",Toast.LENGTH_SHORT).show();
            }
        });







    }

    private void openloginactivity() {
        Intent loginintent =new Intent(this,Login.class);
        startActivity(loginintent);

    }


}
