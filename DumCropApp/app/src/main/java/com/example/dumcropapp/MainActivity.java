package com.example.dumcropapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
     String[] _Data = {"Oryza sativa, commonly known as Asian rice, is the plant species most commonly referred to in English as rice. Oryza sativa is a grass with a genome consisting of 430Mb across 12 chromosomes. It is renowned for being easy to genetically modify and is a model organism for cereal biology",
     "Cotton is a soft, fluffy staple fiber that grows in a boll, or protective case, around the seeds of the cotton plants of the genus Gossypium in the mallow family Malvaceae. The fiber is almost pure cellulose. Under natural conditions, the cotton bolls will increase the dispersal of the seeds",
       "Wheat is one of the world's most commonly consumed cereal grains. It comes from a type of grass (Triticum) that is grown in countless varieties worldwide. Bread wheat, or common wheat, is the primary species. Several other closely related species include durum, spelt, emmer, einkorn, and Khorasan wheat"
     };
     int[] _imgID = {R.drawable.wheat01,R.drawable.wheat01,R.drawable.wheat01};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((ListView) findViewById(R.id.lstCrops)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //    Snackbar.make(view,adapterView.getItemAtPosition(i).toString(),Snackbar.LENGTH_LONG).show();
                Intent _intent = new Intent(MainActivity.this,CropDetailActivity.class);
                _intent.putExtra("cropName",adapterView.getItemAtPosition(i).toString());
                _intent.putExtra("cropDesc",_Data[i].toString());
                _intent.putExtra("cropImg",_imgID[i]);
                startActivity(_intent);

            }
        });
    }
}
