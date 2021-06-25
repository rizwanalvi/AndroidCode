package com.example.cropapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText _txtEmailid ,_txtPassword=null;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.btnSingup).setOnClickListener(this);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        _txtEmailid = findViewById(R.id.txtEmailid);
        _txtPassword = findViewById(R.id.txtPassword);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSingup:
                mAuth.createUserWithEmailAndPassword(_txtEmailid.getText().toString(), _txtPassword.getText().toString())
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Snackbar.make(findViewById(R.id.txtPassword),"Registered",Snackbar.LENGTH_LONG).show();
                                    //    FirebaseUser user = mAuth.getCurrentUser();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Snackbar.make(findViewById(R.id.txtPassword),task.getException().getMessage().toString(),Snackbar.LENGTH_LONG).show();

                                }

                                // ...
                            }
                        });
                break;
            case R.id.btnLogin:

                mAuth.signInWithEmailAndPassword(_txtEmailid.getText().toString().trim(), _txtPassword.getText().toString().trim())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                Intent _intenet = new Intent(MainActivity.this,DashboardActivity.class);
                                startActivity(_intenet);
                                finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                }

                                // ...
                            }
                        });

                break;
        }

    }
}
