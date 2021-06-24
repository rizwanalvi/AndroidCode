package com.example.learnwithfunapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.learnwithfunapp.ml.MobilenetV110224Quant;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button _btnCamera=null;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static  final  int PERMISSION_REQUEST_CODE =101;
    private ImageView _imgObject =null;
    private  Button _btnIdentify=null;
    private   Bitmap imageBitmap =null;
    private TextView _txtResult = null;
    private String[] _toWishList=null;
    private TextToSpeech textToSpeech;
private ArrayList<String> al=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String fileName = "label.txt";
        StringBuilder sb = new StringBuilder();
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
        al = new ArrayList<String>();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
            ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE},102);
            ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE},102);
            // Permission is not granted
            Log.e( "onCreate: ", "Permission is not granted" );
        }
        try {
            InputStream strm = getApplication().getAssets().open(fileName);
            InputStreamReader sr = new InputStreamReader(strm);
            BufferedReader bReader = new BufferedReader(sr);
            String _line = bReader.readLine();

            while (_line !=null){
                    al.add(_line);
               _line = bReader.readLine();
            }


        }
        catch (Exception e){
            Log.e( "File reader Block",e.getMessage() );
        }
        _btnCamera = findViewById(R.id.btnCamera);
        _btnIdentify = findViewById(R.id.btnIdentify);
        _imgObject = findViewById(R.id.imgObject);
        _txtResult = findViewById(R.id.txtResult);
        _btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   dispatchTakePictureIntent();
            try{

                dispatchTakePictureIntent();
            }
        catch (Exception ex){
                Log.e( "onClick: ",ex.getMessage().toString() );
        }
            }
        });
        _btnIdentify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MobilenetV110224Quant model = MobilenetV110224Quant.newInstance(getApplicationContext());
                     Bitmap bmp =  imageBitmap.copy(Bitmap.Config.ARGB_8888,true) ;
                     Bitmap resizebmp = Bitmap.createScaledBitmap(bmp,224,224,true);

                    // Creates inputs for reference.

                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.UINT8);
                    Log.e( "Step1: ","Step 1");

                    TensorImage tm = (TensorImage) TensorImage.fromBitmap(resizebmp);
                    inputFeature0.loadBuffer(tm.getBuffer());
                    Log.e( "Step2: ","Step 2");
                    // Runs model inference and gets result.
                    MobilenetV110224Quant.Outputs outputs = model.process(inputFeature0);
                    Log.e( "Step3: ","Step 3");
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                   _txtResult.setText(al.get(getMax(outputFeature0.getFloatArray())));
                    // Releases model resources if no longer used.
                    model.close();
                 //   Thread.sleep(1000);
                    textToSpeech.speak(_txtResult.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                } catch (Exception e) {
                    // TODO Handle the exception
                    Log.e( "onClick: ",e.getMessage().toString() );
                }


            }
        });
    }
    private int getMax(float[] floatArray){
        int ind =0;
        float min = 0.0f;
        for(int i=0; i<=1000;i++){
            if(floatArray[i]>min){
                ind = i;
                min = floatArray[i];
            }
        }
        return ind;
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        } catch (ActivityNotFoundException e) {
                    // display error state to the user


        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
           imageBitmap = (Bitmap) extras.get("data");
            _imgObject.setImageBitmap(imageBitmap);
        }
    }
    private Bitmap ARGBBitmap(Bitmap img) {
        return img.copy(Bitmap.Config.ARGB_8888,true);
    }
}