package com.example.databaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
private EditText _txtEmailId,_txtPassword,_txtname,_txtCellNo =null;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _txtEmailId = findViewById(R.id.txtEmailId);
        _txtPassword = findViewById(R.id.txtPassword);
        _txtname = findViewById(R.id.txtname);
        _txtCellNo = findViewById(R.id.txtCellNo);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        findViewById(R.id.btnregister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _nEmail = _txtEmailId.getText().toString().trim();
                String _nPassword = _txtPassword.getText().toString().trim();
                mAuth.createUserWithEmailAndPassword(_nEmail, _nPassword)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    DatabaseReference myRef = database.getReference("users");
                                    myRef.child(user.getUid()).setValue(new Customer(user.getUid(),_txtname.getText().toString(),_txtCellNo.getText().toString()));

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Snackbar.make(findViewById(R.id.btnregister),task.getException().getMessage().toString(),Snackbar.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });

            }
        });

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _nEmail = _txtEmailId.getText().toString().trim();
                String _nPassword = _txtPassword.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(_nEmail, _nPassword)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Intent _intnet = new Intent(MainActivity.this,DashboardActivity.class);
                                    startActivity(_intnet);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Snackbar.make(findViewById(R.id.btnregister),task.getException().getMessage().toString(),Snackbar.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        });
    }
}
