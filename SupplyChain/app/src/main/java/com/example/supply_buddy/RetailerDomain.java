package com.example.supply_buddy;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RetailerDomain extends AppCompatActivity {
    private RecyclerView recyclerViewR;
    private RAdapter radapter;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Retailer");
    private ArrayList<Retail> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_domain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewR = findViewById(R.id.recylerviewR);
        recyclerViewR.setHasFixedSize(true);
        recyclerViewR.setLayoutManager(new LinearLayoutManager(this));

        list1=new ArrayList<>();
        radapter= new RAdapter(this,list1);

        recyclerViewR.setAdapter(radapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Retail list = dataSnapshot.getValue(Retail.class);
                    list1.add(list);
                }
                radapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}