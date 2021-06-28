package com.example.practiceapp04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private ListView _lstView=null;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity);
        _lstView = findViewById(R.id.lstView);
        ArrayAdapter dAdapter = ArrayAdapter.createFromResource(this,R.array.lstCourse,R.layout.support_simple_spinner_dropdown_item);
        _lstView.setAdapter(dAdapter);
        _lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //   Toast.makeText(MenuActivity.this, String.valueOf(parent.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
                Intent QuizSub = new Intent(MenuActivity.this,CropActivity.class);
                QuizSub.putExtra("Subj",String.valueOf(parent.getItemAtPosition(position)));
                QuizSub.putExtra("pos",String.valueOf(position));
                startActivity(QuizSub);

            }
        });
    }
}
