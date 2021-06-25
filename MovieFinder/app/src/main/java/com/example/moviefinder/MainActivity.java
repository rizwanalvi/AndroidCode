package com.example.moviefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView _lstMovie =null;
    SearchView _serMovie =null;
    ArrayList<String> _al;
    ArrayAdapter _adapter =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _lstMovie = findViewById(R.id.lstMovie);
        _serMovie = findViewById(R.id.serMovie);
        _al = new ArrayList<>();
        _adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,_al);
        _serMovie.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
              //  Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
                        new JsonBackgroundTask().execute(s);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
    class JsonBackgroundTask extends AsyncTask<String,String,String>{
        // String _movieUrl = "http://www.omdbapi.com/?t=harry&apikey=6ff571af";
        HttpURLConnection _conn = null;
        StringBuilder dBuilder=null;
        @Override
        protected String doInBackground(String... strings) {
            dBuilder = new StringBuilder();
            try{
                URL _url = new URL("http://www.omdbapi.com/?t="+ strings[0].toString()+"&apikey=6ff571af");
                _conn = (HttpURLConnection) _url.openConnection();
                _conn.connect();
                InputStream _strean =  _conn.getInputStream();
                InputStreamReader _sReader = new InputStreamReader(_strean);
                BufferedReader _dReader = new BufferedReader(_sReader);
                String _line = _dReader.readLine();
                while (_line !=null){
                    dBuilder.append(_line);
                    _line = _dReader.readLine();
                }
            }
            catch (Exception ex){}

            return dBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e( "onPostExecute: ",s.toString() );
            try{
                JSONObject _jsoObj = new JSONObject(s.toString());
                String _title = _jsoObj.getString("Title").toString();
                String _poster = _jsoObj.getString("Poster").toString();
                _al.add(_title);
                _lstMovie.setAdapter(_adapter);
            }
            catch (Exception ex){}
        }
    }
}

