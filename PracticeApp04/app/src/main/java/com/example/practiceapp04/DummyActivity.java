package com.example.practiceapp04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DummyActivity extends AppCompatActivity implements View.OnClickListener {
    private Button _btnTrial,_btnPurchase=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        _btnTrial = findViewById(R.id.btnTrial);
        _btnPurchase = findViewById(R.id.btnPurchase);
        _btnTrial.setOnClickListener(this);
        _btnPurchase.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTrial:
                startActivity( new Intent("com.example.practiceapp04.MenuActivity"));
                finish();
                break;
            case  R.id.btnPurchase:
                AlertDialog.Builder dBuilder = new AlertDialog.Builder(this);
                dBuilder.setTitle("Select the course");
                dBuilder.setMessage("Not Supported");
                dBuilder.show();
                break;

        }
    }
}
//  startActivity( new Intent("com.example.practiceapp04.MenuActivity"));