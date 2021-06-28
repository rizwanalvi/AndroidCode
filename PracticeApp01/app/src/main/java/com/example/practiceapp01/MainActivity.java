package com.example.practiceapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button _A1 =null;
    private Button _A2 =null;
    private Button _A3 =null;
    private   Button _B1 =null;
    private   Button _B2 =null;
    private   Button _B3 =null;
    private   Button _C1 =null;
    private   Button _C2 =null;
    private   Button _C3 =null;
    private TextView _txtPlayer1 =null;
    private TextView _txtPlayer2 =null;
    private boolean _turn=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _A1 = findViewById(R.id.A1);
        _A2 = findViewById(R.id.A2);
        _A3 = findViewById(R.id.A3);
        _B1 = findViewById(R.id.B1);
        _B2 = findViewById(R.id.B2);
        _B3 = findViewById(R.id.B3);
        _C1 = findViewById(R.id.C1);
        _C2 = findViewById(R.id.C2);
        _C3 = findViewById(R.id.C3);
        _txtPlayer1 = findViewById(R.id.txtPlayer1);
        _txtPlayer2 = findViewById(R.id.txtPlayer2);
        _B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_turn==true) {
                    _B1.setText("O");
                    _B1.setEnabled(false);
                    _turn=false;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                    Winner();
                }
                else {
                    _B1.setText("X");
                    _B1.setEnabled(false);
                    _turn=true;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Winner();
                }
            }
        });
        _B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_turn==true) {
                    _B2.setText("O");
                    _B2.setEnabled(false);
                    _turn=false;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                    Winner();
                }
                else {
                    _B2.setText("X");
                    _B2.setEnabled(false);
                    _turn=true;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Winner();
                }
            }
        });
        _B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_turn==true) {
                    _B3.setText("O");
                    _B3.setEnabled(false);
                    _turn=false;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                    Winner();
                }
                else {
                    _B3.setText("X");
                    _B3.setEnabled(false);
                    _turn=true;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Winner();
                }
            }
        });
        _C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_turn==true) {
                    _C1.setText("O");
                    _C1.setEnabled(false);
                    _turn=false;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                    Winner();
                }
                else {
                    _C1.setText("X");
                    _C1.setEnabled(false);
                    _turn=true;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Winner();
                }
            }
        });
        _C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_turn==true) {
                    _C2.setText("O");
                    _C2.setEnabled(false);
                    _turn=false;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                }
                else {
                    _C2.setText("X");
                    _C2.setEnabled(false);
                    _turn=true;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Winner();
                }
            }
        });
        _C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_turn==true) {
                    _C3.setText("O");
                    _C3.setEnabled(false);
                    _turn=false;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                    Winner();
                }
                else {
                    _C3.setText("X");
                    _C3.setEnabled(false);
                    _turn=true;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Winner();
                }
            }
        });
        _A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_turn==true) {
                    _A1.setText("O");
                    _A1.setEnabled(false);
                    _turn=false;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                    Winner();
                }
                else {
                    _A1.setText("X");
                    _A1.setEnabled(false);
                    _turn=true;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Winner();
                }
            }
        });
        _A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_turn==true) {
                    _A3.setText("O");
                    _A3.setEnabled(false);
                    _turn=false;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                    Winner();
                }
                else {
                    _A3.setText("X");
                    _A3.setEnabled(false);
                    _turn=true;
                    _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                    _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Winner();
                }
            }
        });

    _A2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(_turn==true) {
                _A2.setText("O");
                _A2.setEnabled(false);
                _turn=false;
                _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                _txtPlayer1.setBackgroundColor(Color.parseColor("#FB4848"));
                Winner();
            }
            else {
                _A2.setText("X");
                _A2.setEnabled(false);
                _turn=true;
                _txtPlayer2.setBackgroundColor(Color.parseColor("#FB4848"));
                _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Winner();
            }
        }
    });

    }
    private void StopPlaying(){
        _A1.setEnabled(false);
        _A2.setEnabled(false);
        _A3.setEnabled(false);
        _B1.setEnabled(false);
        _B2.setEnabled(false);
        _B3.setEnabled(false);
        _C1.setEnabled(false);
        _C2.setEnabled(false);
        _C3.setEnabled(false);



    }
    private void Reset(){
        _A1.setText("");
        _A1.setEnabled(true);
        _A2.setText("");
        _A2.setEnabled(true);
        _A3.setText("");
        _A3.setEnabled(true);

        _B1.setText("");
        _B1.setEnabled(true);
        _B2.setText("");
        _B2.setEnabled(true);
        _B3.setText("");
        _B3.setEnabled(true);

        _C1.setText("");
        _C1.setEnabled(true);
        _C2.setText("");
        _C2.setEnabled(true);
        _C3.setText("");
        _C3.setEnabled(true);

    }
    private void Winner() {
        if((_A1.getText() == _A2.getText()) && (_A2.getText() == _A3.getText())&& !_A3.isEnabled()){
            if(_turn == true){
                _txtPlayer1.setBackgroundColor(Color.parseColor("#00FF00"));
                _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Toast.makeText(this, "Player 1 You Won", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 You Won", Toast.LENGTH_SHORT).show();
                _txtPlayer2.setBackgroundColor(Color.parseColor("#00FF00"));
                _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }

            StopPlaying();
            //  Reset();
        }
        if((_B1.getText() == _B2.getText()) && (_B2.getText() == _B3.getText())&& !_B3.isEnabled()){
            if(_turn == true){
                _txtPlayer1.setBackgroundColor(Color.parseColor("#00FF00"));
                _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Toast.makeText(this, "Player 1 You Won", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 You Won", Toast.LENGTH_SHORT).show();
                _txtPlayer2.setBackgroundColor(Color.parseColor("#00FF00"));
                _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }

            StopPlaying();
        }
        if((_C1.getText() == _C2.getText()) && (_C2.getText() == _C3.getText())&& !_C3.isEnabled()){
            if(_turn == true){
                _txtPlayer1.setBackgroundColor(Color.parseColor("#00FF00"));
                _txtPlayer2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Toast.makeText(this, "Player 1 You Won", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Player 2 You Won", Toast.LENGTH_SHORT).show();
                _txtPlayer2.setBackgroundColor(Color.parseColor("#00FF00"));
                _txtPlayer1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }

            StopPlaying();
        }
        }
    }




