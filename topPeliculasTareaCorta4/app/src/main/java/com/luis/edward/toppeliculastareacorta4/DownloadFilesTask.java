package com.luis.edward.toppeliculastareacorta4;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by estadm on 22/3/2018.
 */

public class DownloadFilesTask extends AsyncTask<String, Void, String> {
    String paginaHtml="NADADA----";

    @Override
    protected String doInBackground(String... urls)//Recibir un array de parametros
    {

        Log.d("---TRY","Va a entrar al");
        try
        {
            // Build and set timeout values for the request.

            Log.d("---RECIBIDO","String recibido fue"+urls[0]);
            URL direccion= new URL("https://www.imdb.com/list/ls064079588/");
            URLConnection connection = (direccion).openConnection();
            //connection.setConnectTimeout(5000);
            //connection.setReadTimeout(5000);
            //connection.connect();

            // Read and store the result line by line then return the entire string.
            InputStream in = connection.getInputStream();
            //BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //StringBuilder html = new StringBuilder();
            InputStreamReader inputStreamReader=new InputStreamReader(in);
            int data=inputStreamReader.read();
            while (data!=-1) {
                char current =(char)data;
                paginaHtml+=current;
                data=inputStreamReader.read();

                Log.d("ALTO----","Se esta leyendo esto: "+paginaHtml);
            }
            in.close();
            return paginaHtml;
           // paginaHtml=html.toString();


        }

        catch (MalformedURLException ex) {
            Log.e("httptest",Log.getStackTraceString(ex));
        }
        catch (IOException ex) {
            Log.e("httptest",Log.getStackTraceString(ex));
        }
        return paginaHtml;
    }
    // This runs in UI when background thread finishes
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        // Do things like hide the progress bar or change a TextView

    }
    }











