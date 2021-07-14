package com.example.supply_buddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity5 extends AppCompatActivity implements LocationListener{
    private Button livelocation;
    public static DatabaseReference reference;
    private LocationManager manager;
    private final int MIN_TIME=1000;
    private final int MIN_DISTANCE=1;
    public static FirebaseUser user;
    public static String uid;
    private static LatLng mTimeSquare;
    public static Marker myMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        manager=(LocationManager)getSystemService(LOCATION_SERVICE);
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        reference= FirebaseDatabase.getInstance().getReference().child("live location").child(uid);
        livelocation = findViewById(R.id.livelocation);
        getLocationUpdate();
        livelocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity5.this, Qr_scanner.class);
                startActivity(intent);


            }
        });

    }



    private void getLocationUpdate() {
        manager=(LocationManager)getSystemService(LOCATION_SERVICE);
        if(manager != null ){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED ) {


                if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
                } else if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
                } else {
                    Toast.makeText(this, "no provider enabled", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},101);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==101){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                getLocationUpdate();
            }
            else {
                Toast.makeText(this,"permission required",Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        if(location!=null){
            saveLocation(location);
        }
        else {
            Toast.makeText(this,"no location",Toast.LENGTH_SHORT).show();
        }

    }
    private void saveLocation(Location location){
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        reference= FirebaseDatabase.getInstance().getReference().child("live location").child(uid);
        LatLng latlang = new LatLng(location.getLatitude(),location.getLongitude());
        reference.setValue(latlang);

    }
}
