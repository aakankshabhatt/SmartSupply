package com.example.supply_buddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FTGR extends AppCompatActivity {
    private TextView farm;
    private TextView trans;
    private TextView god;
    private TextView ret;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_t_g_r);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        farm=findViewById(R.id.farm);
        farm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(FTGR.this, FarmerDomain.class);
                        startActivity(intent);

                    }

        });

        trans=findViewById(R.id.trans);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent intent= new Intent(FTGR.this,TransportDomain.class);
                        startActivity((intent));
                    }

        });

        god=findViewById(R.id.god);
        god.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent intent= new Intent(FTGR.this,GodownDomain.class);
                        startActivity((intent));
                    }
        });

        ret=findViewById(R.id.ret);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent intent= new Intent(FTGR.this,RetailerDomain.class);
                        startActivity((intent));
                    }

        });
    }
}