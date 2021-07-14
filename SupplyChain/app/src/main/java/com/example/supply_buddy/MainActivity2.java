package com.example.supply_buddy;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    private Button btnLogin;
    EditText inputEmail,inputPassword;
    private FirebaseAuth mAuth;
    ProgressDialog mLoadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });
        mAuth=FirebaseAuth.getInstance();
        mLoadingBar=new ProgressDialog(MainActivity2.this);

        //change action title, if you dont change it will be according to your system default language
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources() .getString(R.string.farm));

        Button changeLang = findViewById(R.id.changeMyLang);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show AlertDialog to display list of languages, one can select
                showChangeLanguageDialog();
            }
        });


    }


    //lets create separate string.xml for each language first
    private void showChangeLanguageDialog(){
        //array of languages to display in alert dialog
        final String[] listItems = {"हिंदी","मराठी","தமிழ்","English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity2.this);
        mBuilder.setTitle("Choose Language....");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0){
                    //hindi
                    setLocale("Hi");
                    recreate();
                }
                else if (i==1){
                    //Marathi
                    setLocale("Mr");
                    recreate();
                }
                else if (i==2){
                    //Tamil
                    setLocale("Ta");
                    recreate();
                }
                else if (i==3){
                    //English
                    setLocale("En");
                    recreate();
                }
                //dismiss alert dialog when language selected
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        //show alert dialog
        mDialog.show();

    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext() .getResources() .updateConfiguration(config, getBaseContext() .getResources() .getDisplayMetrics());
        //save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE) .edit();
        editor.putString("My_lang",lang);
        editor.apply();

    }
    //load language saved in shared preferences
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_lang","");
        setLocale(language);

    }
    private void checkCredentials() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();


        if (email.isEmpty() || !email.contains("farmer")) {
            showError(inputEmail, "Your email is invalid!");
        } else if (password.isEmpty() || password.length() < 7) {
            showError(inputPassword, "Your password is invalid!");
        }
        else {
            mLoadingBar.setTitle("Login");
            mLoadingBar.setMessage("Please wait while check your credentials");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        mLoadingBar.dismiss();
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                       // intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                        startActivity(intent);


                    } else {
                        mLoadingBar.dismiss();
                        Toast.makeText(MainActivity2.this, "Incorrect email id / Password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}