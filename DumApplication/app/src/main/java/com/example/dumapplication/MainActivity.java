package com.example.dumapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] _description = {"Rice is the seed of the grass species Oryza glaberrima (African rice) or Oryza sativa (Asian rice).","Cotton is a soft, fluffy staple fiber that grows in a boll, or protective case, around the seeds of the cotton plants of the genus Gossypium in the mallow family",
            "Wheat is one of the world's most commonly consumed cereal grains. It comes from a type of grass (Triticum) that is grown in countless varieties worldwide. Bread wheat, or common wheat, is the primary species. "};
int[] _img = {R.drawable.wheat,R.drawable.wheat,R.drawable.wheat};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((ListView) findViewById(R.id.lstCrops)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
             Intent _Intdata = new Intent(MainActivity.this,Main2Activity.class);
             _Intdata.putExtra("CropName",adapterView.getItemAtPosition(position).toString());
             _Intdata.putExtra("CropDesc",_description[position]);
                _Intdata.putExtra("CropImg",_img[position]);
             startActivity(_Intdata);
//               / Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
