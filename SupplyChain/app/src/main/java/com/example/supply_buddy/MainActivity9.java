package com.example.supply_buddy;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class MainActivity9 extends AppCompatActivity {

    EditText date_txt ,time_txt, quant_gtxt;
    Button submitgodown;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Godown");

    // EditText date_time_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        date_txt=(EditText)findViewById(R.id.date_txt);
        time_txt=(EditText)findViewById(R.id.time_txt);
        quant_gtxt=(EditText)findViewById(R.id.quant_gtxt);


        submitgodown=(Button)findViewById(R.id.submitgodown);
        submitgodown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String date = date_txt.getText().toString();
                String time = time_txt.getText().toString();
                String quantity=quant_gtxt.getText().toString();

                HashMap<String,String> userMap =new HashMap<>();

                userMap.put("date",date);
                userMap.put("time",time);
                userMap.put("quantity",quantity);
                root.push().setValue(userMap);

                Intent intent = new Intent(MainActivity9.this, MainActivity10.class);
               // intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                startActivity(intent);
            }
        });

        date_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(date_txt);
            }
        });

        time_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(time_txt);
            }
        });


    }


    private void showTimeDialog(final EditText time_in) {
        final Calendar calendar=Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
                time_in.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        new TimePickerDialog(MainActivity9.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }

    private void showDateDialog(final EditText date_in) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
                date_in.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new DatePickerDialog(MainActivity9.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

}