package com.example.cropapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardActivity extends AppCompatActivity {

FirebaseAuth _mAuth =null;
FirebaseUser _User =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        _mAuth = FirebaseAuth.getInstance();
        _User = _mAuth.getCurrentUser();
        TextView _Heading = findViewById(R.id.txtHeading);
        _Heading.setText(_User.getEmail().toString());
        findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase mDatabase  = FirebaseDatabase.getInstance();
                DatabaseReference mRef = mDatabase.getReference("Crop");
                mRef.setValue(new Crop("Wheat","250"));
                Toast.makeText(DashboardActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater _mnuinflate = getMenuInflater();
        _mnuinflate.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        _mAuth.signOut();
        Intent _intenet = new Intent(DashboardActivity.this,MainActivity.class);
        startActivity(_intenet);
        finish();
        return true;
    }
}
