package com.example.supply_buddy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Qr_scannergodown extends AppCompatActivity {

    Button btScan1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scannergodown);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btScan1=findViewById(R.id.bt_scan1);

        btScan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator=new IntentIntegrator(
                        Qr_scannergodown.this
                );
                intentIntegrator.setPrompt("For flash use volume up key");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult=IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );
        if(intentResult.getContents()!=null){
            AlertDialog.Builder builder=new AlertDialog.Builder(
                    Qr_scannergodown.this
            );
            builder.setTitle("Successfully Scanned");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Intent intent = new Intent(Qr_scannergodown.this,MainActivity9.class);
                    //intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                    startActivity(intent);
                }
            });
            builder.show();

        }else{
            Toast.makeText(getApplicationContext()
                    ,"OOPS...You did not scan anything",Toast.LENGTH_SHORT)
                    .show();
        }
    }
}