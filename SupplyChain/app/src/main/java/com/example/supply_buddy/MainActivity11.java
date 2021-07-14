package com.example.supply_buddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity11 extends AppCompatActivity {
    private Button btnLogin;
    EditText inputEmail,inputPassword;
    private FirebaseAuth mAuth;
    ProgressDialog mLoadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnLogin=findViewById(R.id.btnLogin);
        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });
        mAuth=FirebaseAuth.getInstance();
        mLoadingBar=new ProgressDialog(MainActivity11.this);

    }
    private void checkCredentials(){
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();


        if (email.isEmpty() || !email.contains("retail"))
        {
            showError(inputEmail,"Your email is invalid!");
        }
        else if (password.isEmpty() || password.length()<7)
        {
            showError(inputPassword,"Your password is invalid!");
        }

        else
        {
            mLoadingBar.setTitle("Login");
            mLoadingBar.setMessage("Please wait while check your credentials");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        mLoadingBar.dismiss();
                        Intent intent = new Intent(MainActivity11.this, MainActivity12.class);
                        //intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                        startActivity(intent);


                    }
                    else{
                        mLoadingBar.dismiss();
                        Toast.makeText(MainActivity11.this, "Incorrect email id / Password", Toast.LENGTH_SHORT).show();
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