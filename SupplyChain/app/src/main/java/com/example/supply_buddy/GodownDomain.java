package com.example.supply_buddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


public class GodownDomain extends AppCompatActivity {
    private RecyclerView recyclerViewG;
    private GAdapter gadapter;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Godown");
    private ArrayList<Godown> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_godown_domain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewG = findViewById(R.id.recylerviewG);
        recyclerViewG.setHasFixedSize(true);
        recyclerViewG.setLayoutManager(new LinearLayoutManager(this));

        list1=new ArrayList<>();
        gadapter= new GAdapter(this,list1);

        recyclerViewG.setAdapter(gadapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Godown list = dataSnapshot.getValue(Godown.class);
                    list1.add(list);
                }
                gadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}


