package com.example.practiceapp04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CropActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView _txtSubj = null;
    private ImageView _imgView =null;
    private TextView _txtDetails=null;
private Button _btnAuction=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        _txtSubj = findViewById(R.id.txtSubject);
        _txtDetails = findViewById(R.id.txtDetails);
        Intent inData = getIntent();
       _txtSubj.setText(inData.getStringExtra("Subj"));
        String _CropId = inData.getStringExtra("pos");
        _imgView = findViewById(R.id.imgView);
        _imgView.setImageResource(new CropBank().GetImage(Integer.parseInt( _CropId)));
        _txtDetails.setText(new CropBank().GetDetails(Integer.parseInt( _CropId)));
        _btnAuction = findViewById(R.id.btnAction);
        _btnAuction.setOnClickListener(this);


        }


    @Override
    public void onClick(View v) {

        final CharSequence[] items ={"None","Rs.5000","Rs.1000","Rs.15000","Rs.20000"};
        boolean[] isItems = new boolean[items.length];
        AlertDialog.Builder dBuilder1 = new AlertDialog.Builder(this);
        dBuilder1.setTitle("Select Your Bid");
        dBuilder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CropActivity.this, "Bid Register", Toast.LENGTH_SHORT).show();
            }
        });
        dBuilder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // Toast.makeText(CropActivity.this, "No", Toast.LENGTH_SHORT).show();

            }
        });
        dBuilder1.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(CropActivity.this, "Action has been Register", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        dBuilder1.show();
        }
    }



