package com.example.firebasedumpingapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundTaskJson extends AsyncTask<String,String,String> {
    private String JsonData=null;
    public BackgroundTaskJson() {
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection _Conn = null;
        StringBuilder dBuilder = new StringBuilder();
       try{
        URL _url = new URL(strings[0]);
       _Conn = (HttpURLConnection) _url.openConnection();
       InputStream _inStream = _Conn.getInputStream();
           InputStreamReader _inReader = new InputStreamReader(_inStream);
           BufferedReader bReader = new BufferedReader(_inReader);
           String _line = bReader.readLine();
           while (_line !=null){
                dBuilder.append(_line);
                _line = bReader.readLine();
           }
       }
       catch (Exception ex){

       }
        return dBuilder.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        JsonData = s;
        Log.e( "onPostExecute: ", s.toString());
    }


    public void setJsondata(String jsondata) {
        JsonData = jsondata;
    }

    public String GetJsonData(){
        return  JsonData;
    }

}
