package com.example.supply_buddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class MainActivity3 extends AppCompatActivity {

    EditText txtname,txtrm,txtfrom,txtto,txtquant,txtloc;
    Button submit, submit4;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Farmers");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtname=(EditText)findViewById(R.id.txtname);
        txtrm=(EditText)findViewById(R.id.txtrm);
        txtfrom=(EditText)findViewById(R.id.txtfrom);
        txtto=(EditText)findViewById(R.id.txtto);
        txtquant=(EditText)findViewById(R.id.txtquant);
        txtloc=(EditText)findViewById(R.id.txtloc);

        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtname.getText().toString();
                String raw_material = txtrm.getText().toString();
                String from=txtfrom.getText().toString();
                String to=txtto.getText().toString();
                String quant=txtquant.getText().toString();
                String loc = txtloc.getText().toString();

                HashMap<String,String> userMap =new HashMap<>();

                userMap.put("name",name);
                userMap.put("raw_material",raw_material);
                userMap.put("from",from);
                userMap.put("to",to);
                userMap.put("quantity",quant);
                userMap.put("location",loc);

                root.push().setValue(userMap);
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);

            }
        });


    }
}