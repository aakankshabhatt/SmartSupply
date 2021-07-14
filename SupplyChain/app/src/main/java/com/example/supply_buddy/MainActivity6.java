package com.example.supply_buddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity6 extends AppCompatActivity {
    EditText quant_ttxt,box_txt,loc_ttxt,cp_txt;
    Button submittran;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Transporter");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        quant_ttxt=(EditText)findViewById(R.id.quant_ttxt);
        box_txt=(EditText)findViewById(R.id.box_txt);
        loc_ttxt=(EditText)findViewById(R.id.loc_ttxt);
        cp_txt=(EditText)findViewById(R.id.cp_txt);


        submittran=(Button)findViewById(R.id.submittran);
        submittran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String quantityt=quant_ttxt.getText().toString();
                String boxes=box_txt.getText().toString();
                String locationt=loc_ttxt.getText().toString();
                String confirmPrizet = cp_txt.getText().toString();


                HashMap<String,String> userMap =new HashMap<>();


                userMap.put("quantity",quantityt);
                userMap.put("boxes",boxes);
                userMap.put("location",locationt);
                userMap.put("confirmPrize",confirmPrizet);

                root.push().setValue(userMap);
                startActivity(new Intent(MainActivity6.this,MainActivity7.class));
            }
        });


    }
}