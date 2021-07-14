package com.example.supply_buddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TransportDomain extends AppCompatActivity {
    private Button btn_track;
    private RecyclerView recyclerViewt;
    private TAdapter tadapter;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Transporter");
    private ArrayList<Transporter> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_domain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewt = findViewById(R.id.recylerviewt);
        recyclerViewt.setHasFixedSize(true);
        recyclerViewt.setLayoutManager(new LinearLayoutManager(this));

        list1=new ArrayList<>();
        tadapter= new TAdapter(this,list1);

        recyclerViewt.setAdapter(tadapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Transporter list = dataSnapshot.getValue(Transporter.class);
                    list1.add(list);
                }
                tadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        btn_track=findViewById(R.id.btn_track);
        btn_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TransportDomain.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}