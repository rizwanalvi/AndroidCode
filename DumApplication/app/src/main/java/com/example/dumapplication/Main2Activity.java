package com.example.dumapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView _txtCropName,_txtCropDesc;
    ImageView _imgData=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent _ind = getIntent();
        String CropName = _ind.getStringExtra("CropName");
        String CropDesc = _ind.getStringExtra("CropDesc");
        int _imgid = _ind.getIntExtra("CropImg",0);
        _txtCropName = findViewById(R.id.txtCropName);
        _txtCropDesc = findViewById(R.id.txtCropDesc);
        _txtCropName.setText(CropName);
        _txtCropDesc.setText(CropDesc);
        _imgData = findViewById(R.id.imgData);
        _imgData.setImageResource(_imgid);
    }
}
