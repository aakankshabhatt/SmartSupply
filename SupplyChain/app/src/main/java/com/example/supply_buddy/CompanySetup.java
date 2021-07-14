package com.example.supply_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompanySetup extends AppCompatActivity {
    private Button monactmain;
    private Button cussetmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_setup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cussetmain=findViewById(R.id.cussetmain);
        cussetmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CompanySetup.this,AdmimLogin.class);
                startActivity((intent));
            }
        });

        monactmain=findViewById(R.id.monactmain);
        monactmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CompanySetup.this,FTGR.class);
                startActivity((intent));
            }
        });
    }
}