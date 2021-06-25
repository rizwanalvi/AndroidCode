package com.example.dumcropapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CropDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_detail);
        Intent _intent = getIntent();
        String _heading = _intent.getStringExtra("cropName");
        String _Desce = _intent.getStringExtra("cropDesc");
        int _id = _intent.getIntExtra("cropImg",0);
        ImageView _imgview = findViewById(R.id.imgData);
        TextView _txtheading = findViewById(R.id.txtHeading);
        _txtheading.setText(_heading);
        ((TextView) findViewById(R.id.txtDesc)).setText(_Desce);
        _imgview.setImageResource(_id);
        ((Button) findViewById(R.id.btnPlaceBid)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _listItem[] = {"None","5000","10000","15000","20000"};
                AlertDialog.Builder dAlert = new AlertDialog.Builder(CropDetailActivity.this);
                dAlert.setTitle("Select Your Bid");
                dAlert.setSingleChoiceItems(_listItem, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dAlert.show();
            }
        });
    }
}
