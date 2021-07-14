package com.example.supply_buddy;



import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button farmerpage;
    private Button transport_page;
    private Button godownpage;
    private Button retailpage;
    private ImageButton comsetup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        farmerpage=findViewById(R.id.farmerpage);
        farmerpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity((intent));
            }
        });

        transport_page=findViewById(R.id.transport_page);
        transport_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Transport_login.class);
                startActivity(intent);
            }
        });

        godownpage=findViewById(R.id.godownpage);
        godownpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,MainActivity8.class);
                startActivity((intent));
            }
        });

        retailpage=findViewById(R.id.retailpage);
        retailpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,MainActivity11.class);
                startActivity((intent));
            }
        });

        comsetup=findViewById(R.id.comsetup);
        comsetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,CompanySetup.class);
                startActivity((intent));
            }
        });
    }
}
