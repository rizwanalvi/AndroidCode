package com.example.firebasedumpingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
ImageButton _btnLogin=null;

EditText _txtEmaill,_txtPassword,_txtName,_txtCellNo =null;
    CircleImageView _profile_image=null;
    private FirebaseAuth mAuth;
    private StorageReference mStorageRef;
    private Uri imgPath=null;
    String _guid =null;
    ProgressDialog pd = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        _btnLogin = findViewById(R.id.btnLogin);
        _profile_image = findViewById(R.id.profile_image);
        _txtEmaill = findViewById(R.id.txtEmaill);
        _txtPassword = findViewById(R.id.txtPassword);
        _txtName = findViewById(R.id.txtName);
        _txtCellNo = findViewById(R.id.txtCellNo);

        _profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //        Snackbar.make(view,"Show data here",Snackbar.LENGTH_LONG).show();
             Intent _IntentGetimg = new Intent();
            _IntentGetimg.setType("image/*");
            _IntentGetimg.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(_IntentGetimg,0);


            }
        });
        findViewById(R.id.btnRegisetr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd = new ProgressDialog(MainActivity.this);
                final String emialid = _txtEmaill.getText().toString();
                final String pass = _txtPassword.getText().toString();
                final String name = _txtName.getText().toString();
                final String celno = _txtCellNo.getText().toString();
                final String imgpath = imgPath.getPath();
                pd.show();
                mAuth.createUserWithEmailAndPassword(emialid, pass)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    _guid = user.getUid();

                                    mStorageRef = FirebaseStorage.getInstance().getReference();
                                    String _location = "img/"+_guid.toString() + ".png";
                                    final StorageReference riversRef = mStorageRef.child(_location);

                                    riversRef.putFile(imgPath)
                                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                @Override
                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                    // Get a URL to the uploaded content
                                                   //Uri downloadUrl = taskSnapshot.getDownloadUrl();

                                                    riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                        @Override
                                                        public void onSuccess(Uri uri) {

                                                            //https://firebasestorage.googleapis.com/v0/b/smsc-3c33a.appspot.com/o/images%2FrokCIeKfOvhIzYTKSWQNsgVzaQ73?alt=media&token=8d003496-9093-49bd-a167-879c1a0a8b86
                                                        String _link = "https://firebasestorage.googleapis.com";
                                                        String _token = "?alt=media&token=8d003496-9093-49bd-a167-879c1a0a8b86";
                                                        String _ph = uri.getPath();
                                                        //BackgroundTaskJson bg = new BackgroundTaskJson();
                                                      //  bg.execute("https://firebasestorage.googleapis.com/v0/b/smsc-3c33a.appspot.com/o/images%2FrokCIeKfOvhIzYTKSWQNsgVzaQ73");


                                                            String _imgFirebasepath = _link +_ph+_token;
                                                            Log.e( "onSuccess 01: ", _ph);
                                                            Log.e( "onSuccess 02: ", _imgFirebasepath);
                                                          //  Log.e( "onSuccess 03: ", bg.GetJsonData());
                                                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                                                            DatabaseReference myRef = database.getReference("");
                                                            myRef.child("Users").child(_guid).setValue(new User(_guid,emialid,name,celno,_imgFirebasepath));
                                                        }
                                                    });
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception exception) {
                                                    // Handle unsuccessful uploads
                                                    // ...
                                                }
                                            });

                           pd.dismiss();

                                } else {
                                    // If sign in fails, display a message to the user.

                                }

                                // ...
                            }
                        });


            }
        });
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent _intent = new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(_intent);
                finish();


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imgPath = data.getData();
        Picasso.get().load(imgPath).into(_profile_image);

    }
}
