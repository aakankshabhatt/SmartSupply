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

public class MainActivity12 extends AppCompatActivity {
    EditText rm_rtxt,from_rtxt,to_rtxt,quant_rtxt,loc_rtxt;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Retailer");
    Button submitretail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        rm_rtxt=(EditText)findViewById(R.id.rm_rtxt);
        from_rtxt=(EditText)findViewById(R.id.from_rtxt);
        to_rtxt=(EditText)findViewById(R.id.to_rtxt);
        quant_rtxt=(EditText)findViewById(R.id.quant_rtxt);
        loc_rtxt=(EditText)findViewById(R.id.loc_rtxt);

        submitretail=(Button)findViewById(R.id.submitretail);
              submitretail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String raw_material =rm_rtxt.getText().toString();
                String from=from_rtxt.getText().toString();
                String to=to_rtxt.getText().toString();
                String quantity=quant_rtxt.getText().toString();
                String location = loc_rtxt.getText().toString();

                HashMap<String,String> userMap =new HashMap<>();


                userMap.put("raw_material",raw_material);
                userMap.put("from",from);
                userMap.put("to",to);
                userMap.put("quantity",quantity);
                userMap.put("location",location);

                root.push().setValue(userMap);
                startActivity(new Intent(MainActivity12.this,MainActivity13.class));
            }
        });

    }
}